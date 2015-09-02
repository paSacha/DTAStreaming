/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.servlet;

import dtastreaming.entity.Film;
import dtastreaming.entity.Pays;
import dtastreaming.service.CastingService;
import dtastreaming.service.FilmService;
import dtastreaming.service.GenreService;
import dtastreaming.service.PaysService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ETY
 */
@WebServlet(name = "ModifierFilmServlet", urlPatterns = {"/film_modifier"})
public class ModifierFilmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       Film f = new FilmService().rechercher(Integer.parseInt(req.getParameter("id_R")));
        req.setAttribute("mesPays", new PaysService().lister());
        req.setAttribute("mesCasting", new CastingService().lister());
        req.setAttribute("mesGenres", new GenreService().lister());
        req.setAttribute("monFilm", f);
        req.getRequestDispatcher("admin_film_modifier.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pays p = new Pays();
        Film f = new FilmService().rechercher(Integer.parseInt(req.getParameter("id_R")));
        
        f.setTitle( req.getParameter("champ_titre"));
        f.setResume(req.getParameter("champ_resume"));
        f.setAnnee(Integer.parseInt(req.getParameter("champ_annee")));
        p.setId(req.getParameter("champ_pays"));
        if (!"".equals(p.getId())) 
            f.setPays(p);
        f.setDuree(Integer.parseInt(req.getParameter("champ_duree")));
        new FilmService().modifier(f);
        
        resp.sendRedirect("film_lister");
    }
    
    
}

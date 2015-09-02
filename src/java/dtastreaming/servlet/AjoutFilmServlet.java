/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.servlet;

import dtastreaming.entity.Casting;
import dtastreaming.entity.Film;
import dtastreaming.entity.FilmCasting;
import dtastreaming.entity.Genre;
import dtastreaming.entity.Pays;
import dtastreaming.entity.RoleEnum;
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
@WebServlet(name = "AjoutFilmServlet", urlPatterns = {"/film_ajout"})
public class AjoutFilmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.setAttribute("mesPays", new PaysService().lister());
        req.setAttribute("mesCasting", new CastingService().lister());
        req.setAttribute("mesGenres", new GenreService().lister());
        req.getRequestDispatcher("admin_film_ajouter.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Film f = new Film();
        
        f.setTitle( req.getParameter("champ_titre"));
        f.setResume(req.getParameter("champ_resume"));
        f.setAnnee(new Integer(req.getParameter("champ_annee")));
        f.setDuree(new Integer(req.getParameter("champ_duree")));

        // Set pays
        Pays p = new Pays();
        p.setId( req.getParameter("champ_pays") );
        f.setPays(p);
        p.getFilms().add(f);
        
        //Set genre
        Genre g = new Genre();
        g.setId(req.getParameter("champ_genre"));
        f.getGenres().add(g);
        g.getFilms().add(f);    
        
        //Set casting
        FilmCasting fc = new FilmCasting();
        FilmCasting fc2 = new FilmCasting();
        Casting cR = new CastingService().rechercher(new Integer(req.getParameter("champ_castingR")));
        Casting cA = new CastingService().rechercher(new Integer(req.getParameter("champ_castingA")));
            //Set Realisateur
            fc.setFilm(f);
            fc.setCasting(cR);
            fc.setRole(RoleEnum.REAL);
            f.getFilmCastings().add(fc);
            cR.getFilmCastings().add(fc);
            //Set Acteur
            fc2.setFilm(f);
            fc2.setCasting(cA);
            fc2.setRole(RoleEnum.ACTOR);
            f.getFilmCastings().add(fc2);
            cA.getFilmCastings().add(fc2);
      
        new FilmService().ajouter(f);
        
        //Forward
        resp.sendRedirect("film_ajout");
    }
    
    
}

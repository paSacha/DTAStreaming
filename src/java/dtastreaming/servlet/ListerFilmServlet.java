/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.servlet;

import dtastreaming.entity.Film;
import dtastreaming.service.CastingService;
import dtastreaming.service.FilmService;
import dtastreaming.service.GenreService;
import dtastreaming.service.PaysService;
import dtastreaming.service.RechercheService;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ETY
 */
@WebServlet(urlPatterns = {"/film_lister"})
public class ListerFilmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // Récupère liste des films
        Collection<Film> films = new FilmService().lister();

        req.setAttribute("mesPays", new PaysService().lister());
        req.setAttribute("mesCasting", new CastingService().lister());
        req.setAttribute("mesGenres", new GenreService().lister());
        req.setAttribute("mesFilms", films);
        req.getRequestDispatcher("admin_film_lister.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Collection<Film> films;
        films = new RechercheService().listerFilmAllParam(
                req.getParameter("Rchamp_genre"), 
                req.getParameter("Rchamp_pays"), 
                req.getParameter("Rchamp_casting"), 
                req.getParameter("Rchamp_titre"), 
                req.getParameter("Rchamp_annee"));

        req.setAttribute("mesPays", new PaysService().lister());
        req.setAttribute("mesCasting", new CastingService().lister());
        req.setAttribute("mesGenres", new GenreService().lister());
        req.setAttribute("mesFilms", films);
        req.getRequestDispatcher("admin_film_lister.jsp").forward(req, resp);
    }
}

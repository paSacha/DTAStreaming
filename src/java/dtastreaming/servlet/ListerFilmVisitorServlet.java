/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.servlet;

import dtastreaming.entity.Film;
import dtastreaming.service.FilmService;
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
@WebServlet(urlPatterns = {"/film_lister_visitor"})
public class ListerFilmVisitorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // Récupère liste des films
        Collection<Film> films = new FilmService().lister();
        //Envoie vers JSP
        req.setAttribute("mesFilms", films);
        req.getRequestDispatcher("visitor_film_lister.jsp").forward(req, resp);
    }
    
    
}

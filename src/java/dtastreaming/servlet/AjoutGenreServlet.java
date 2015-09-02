/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.servlet;

import dtastreaming.entity.Genre;
import dtastreaming.service.CastingService;
import dtastreaming.service.GenreService;
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
@WebServlet(name = "AjoutGenreServlet", urlPatterns = {"/genre_ajout"})
public class AjoutGenreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getRequestDispatcher("admin_genre_ajouter.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Genre p = new Genre();
        
        if (!"".equals(req.getParameter("champ_nom")))
            p.setId(req.getParameter("champ_nom"));

        new GenreService().ajouter(p);
        

        resp.sendRedirect("genre_lister");
    }
    
}

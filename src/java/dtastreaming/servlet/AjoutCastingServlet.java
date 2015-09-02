/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.servlet;

import dtastreaming.entity.Casting;
import dtastreaming.service.CastingService;
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
@WebServlet(name = "AjoutCastingServlet", urlPatterns = {"/casting_ajout"})
public class AjoutCastingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getRequestDispatcher("admin_casting_ajouter.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Casting p = new Casting();
        
        if (!"".equals(req.getParameter("champ_nom")))
            p.setNom(req.getParameter("champ_nom"));

        new CastingService().ajouter(p);
        
        resp.sendRedirect("casting_lister");
    }
    
}

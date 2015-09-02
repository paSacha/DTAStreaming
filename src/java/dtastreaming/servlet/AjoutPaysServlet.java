/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.servlet;

import dtastreaming.entity.Pays;
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
@WebServlet(name = "AjoutPaysServlet", urlPatterns = {"/pays_ajout"})
public class AjoutPaysServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getRequestDispatcher("admin_pays_ajouter.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pays p = new Pays();
        
        if (!"".equals(req.getParameter("champ_nom")))
            p.setId(req.getParameter("champ_nom"));

        new PaysService().ajouter(p);
        
        //Forward
        resp.sendRedirect("pays_lister");
    }
    
}

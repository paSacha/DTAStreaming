/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ETY
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
//        Permet de passer par des variables de session (mêmme genre que les cookies)
//        req.getSession().setAttribute(null, resp);
        
        resp.addCookie(new Cookie("log",req.getParameter("champ_login")));
        resp.addCookie(new Cookie("mdp",req.getParameter("champ_mdp")));
        
        if ("admin".equals(req.getParameter("champ_login")) && "admin".equals(req.getParameter("champ_mdp")))
            resp.sendRedirect("film_lister");
        else
            resp.sendRedirect("film_lister_visitor");
    }

}

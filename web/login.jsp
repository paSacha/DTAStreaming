<%-- 
    Document   : login
    Created on : 21 août 2015, 16:34:31
    Author     : ETY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <c:import url="_STYLESHEETS.jsp"/>
        <c:import url="_JAVASCRIPTS.jsp"/> 
    </head>
    <body>
        
        <div class="menu">
            <c:import url="_MENU.jsp"/> 
        </div>
        <div class="contenu">
            <form method="post">
                <br>
		<div class="field_group">
                    <label for="champ_login"> Login</label>
                    <input type="text" name="champ_login" required="required">
		</div>
		<br>
		<div class="field_group">	
                    <label for="champ_mdp"> Mot de passe</label>
                    <input type="text" name="champ_mdp" required="required">
		</div>
                <br>
		<div class="field_group">
                    <input type="submit" value="OK">
		</div>
            </form>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/> 
        </div>
        
    </body>
</html>

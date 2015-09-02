<%-- 
    Document   : admin_pays_ajouter
    Created on : 19 août 2015, 16:38:37
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
		<div class="field_group">
                    <label for="champ_nom"> Nom (Champ obligatoire)</label>
                    <input type="text" name="champ_nom" required="required">
		</div>
		<br>
		<div class="field_group">
                    <input type="submit" value="Ajouter un genre">
		</div>
            </form>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/> 
        </div>
        
    </body>
</html>

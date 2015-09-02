<%-- 
    Document   : admin_genre_lister
    Created on : 19 août 2015, 16:13:56
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
            
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">
                    Liste des genres
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="genre_ajout" class="glyphicon glyphicon-plus">  Ajouter un genre</a>
                </div>
                <div class="panel-body">
                    <c:forEach items="${requestScope.mesGenres}" var="monGenre">
                        ${monGenre.id}
                        <a href="genre_supprimer?id=${monGenre.id}" class="glyphicon glyphicon-trash "></a>
                        <br>
                    </c:forEach>
                </div>
              </div>
            
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/> 
        </div>
        
    </body>
</html>

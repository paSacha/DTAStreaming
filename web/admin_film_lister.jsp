<%-- 
    Document   : admin_film_lister
    Created on : 19 août 2015, 14:42:34
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
            <br>
            <c:import url="_RECHERCHE.jsp"/> 
            <br>
        </div>
        <div class="contenu">
            
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">
                    Liste des films
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="film_ajout" class="glyphicon glyphicon-plus">  Ajouter un film</a>
                </div>
                <div class="panel-body">
                    <c:forEach items="${requestScope.mesFilms}" var="monFilm">
                        ${monFilm.title}
                        &nbsp;
                        Pays:
                        ${monFilm.pays.id}
                        &nbsp;
                        Genres:[
                        <c:forEach items="${monFilm.genres}" var="genre">
                            ${genre.id}
                        &nbsp;
                        </c:forEach>
                        ]
                        &nbsp;
                        Casting:[
                        <c:forEach items="${monFilm.filmCastings}" var="filmCasting">
                            ${filmCasting.casting.nom}
                        &nbsp;
                        </c:forEach>
                        ]
                        <a href="film_supprimer?id=${monFilm.id}" class="glyphicon glyphicon-trash "></a>
                        <a href="film_modifier?id_R=${monFilm.id}" class="glyphicon glyphicon-pencil"></a>
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



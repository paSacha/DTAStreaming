<%-- 
    Document   : admin_film_ajouter
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
                    <label for="champ_titre"> Titre (Champ obligatoire)</label>
                    <input type="text" name="champ_titre" required="required">
		</div>
		<br>
		<div class="field_group">	
                    <label for="champ_resume"> Résumé</label>
                    <input type="text" name="champ_resume">
		</div>
		<br>
		<div class="field_group">
                    <label for="champ_genre"> Genre</label>
                    <select name="champ_genre">
                    <c:forEach items="${requestScope.mesGenres}" var="monGenre">
                        <option value="${monGenre.id}">${monGenre.id}</option>
                    </c:forEach>
                    </select>
		</div>
		<br>
		<div class="field_group">
                    <label for="champ_castingR"> Réalisateurs</label>
                    <select name="champ_castingR">
                    <c:forEach items="${requestScope.mesCasting}" var="monCastingR">
                        <option value="${monCastingR.id}">${monCastingR.nom}</option>
                    </c:forEach>
                    </select>
		</div>
                <div class="field_group">
                    <label for="champ_castingA"> Acteurs</label>
                    <select name="champ_castingA">
                    <c:forEach items="${requestScope.mesCasting}" var="monCastingA">
                        <option value="${monCastingA.id}">${monCastingA.nom}</option>
                    </c:forEach>
                    </select>
		</div>
                <br>
		<div class="field_group">
                    <label for="champ_pays"> Pays</label>
                    <select name="champ_pays">
                    <c:forEach items="${requestScope.mesPays}" var="monPays">
                        <option value="${monPays.id}">${monPays.id}</option>
                    </c:forEach>
                    </select>
		</div>
                <br>
		<div class="field_group">
                    <label for="champ_duree"> Durée</label>
                    <input type="text" name="champ_duree">
		</div>
                <br>
		<div class="field_group">
                    <label for="champ_annee"> Année</label>
                    <input type="text" name="champ_annee">
		</div>
		<br>
		<div class="field_group">
                    <input type="submit" value="Valider les infos">
		</div>
            </form>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/> 
        </div>
        
    </body>
</html>

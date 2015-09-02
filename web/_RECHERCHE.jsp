<%-- 
    Document   : _MENU
    Created on : 19 août 2015, 15:55:45
    Author     : ETY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">Rechercher un film</h3>
  </div>
  <div class="panel-body">
    <form method="post">
        <div class="field_group">
            <label for="Rchamp_titre"> Titre </label>
            <input type="text" name="Rchamp_titre" >
        </div>
        &nbsp;
        <div class="field_group">
            <label for="Rchamp_genre"> Genre</label>
            <select name="Rchamp_genre">
            <c:forEach items="${requestScope.mesGenres}" var="monGenre">
                <option value="${monGenre.id}">${monGenre.id}</option>
            </c:forEach>
            </select>
        </div>
        <br>
        <div class="field_group">
            <label for="Rchamp_casting"> Casting</label>
            <input type="text" name="Rchamp_casting" >
        </div>
        &nbsp;
        <div class="field_group">
            <label for="Rchamp_pays"> Pays</label>
            <select name="Rchamp_pays">
            <c:forEach items="${requestScope.mesPays}" var="monPays">
                <option value="${monPays.id}">${monPays.id}</option>
            </c:forEach>
            </select>
        </div>
        &nbsp;
        <div class="field_group">
            <label for="Rchamp_annee"> Année</label>
            <input type="text" name="Rchamp_annee">
        </div>
        <br>
        <div class="field_group">
            <input type="submit" value="Rechercher" class="btn btn-default">
        </div>
    </form>
  </div>
</div>



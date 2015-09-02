<%-- 
    Document   : _MENU
    Created on : 19 août 2015, 15:55:45
    Author     : ETY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
        <c:if test="${cookie.log.value=='admin'}">
            <a href="film_lister">Films</a> &nbsp;
            <a href="genre_lister">Genres</a> &nbsp;
            <a href="pays_lister">Pays</a> &nbsp;
            <a href="casting_lister">Castings</a>
        </c:if>

        <c:if test="${cookie.log.value!='admin'}">
            <a href="film_lister_visitor">Films</a>
        </c:if>

        &nbsp;&nbsp;&nbsp;&nbsp;
        <a href="login">Login</a> &nbsp;
        <a href="logout">Logout</a>  
    </div>
  </div>
</nav>




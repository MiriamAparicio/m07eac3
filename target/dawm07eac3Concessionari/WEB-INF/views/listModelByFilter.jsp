<%-- 
    Document   : listModelByFilter
    Created on : 23/11/2017, 15:36:41
    Author     : Miriam
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <!-- jQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <title>Concessionari</title>
    </head>
    <body>
        <nav>
            <ul class="nav nav-pills">
                <li role="presentation" class="active">
                    <a href="<spring:url value= '/'/>">
                        Inici
                    </a>
                </li>
                <sec:authorize access="hasRole('ROLE-ADMIN') or hasRole('ROLE-USER')">
                <li role="Presentation" class="">                
                    <a href="<c:url value="/j_spring_security_logout" />" class="btn btndanger btn-mini pull-right">desconnectar</a>
                </li>
                </sec:authorize>                      
            </ul>    
        </nav>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>${banner}</h1>
                    <p>${tagline}</p>
                </div>
            </div>
        </section>
        <section class="container">
            <div class="row">
                <c:forEach items="${model}" var="model">
                    <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                        <div class="thumbnail">
                            <div class="caption">
                                <h3><strong>Model: </strong>${model.model}</h3>
                                <p>Codi: ${model.codi}</p>
                                <p>Descripció: ${model.descripcio}</p>
                                <p>Té un preu de: ${model.preu}</p>
                                <p>Té: ${model.km}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </section>                
    </body>
</html>


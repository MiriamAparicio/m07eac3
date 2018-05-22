<%-- 
    
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
        <div class="jumbotron">
            <div class="container">
                <h1>${banner}</h1>
            </div>
        </div>
        <section class="container">
            <form class="form-horizontal" method="POST" action="/dawm07eac3Concessionari/get">
                <fieldset>
                <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="codi">Codi</label>
                        <div class="col-xs-3">
                            <input class="form-control" placeholder="codi" name="codi" type="text">
                            <p></p>
                            <input class="btn btn-primary" type="submit" value="Consultar">
                        </div>                        
                </fielset>
            </form>            
        </section>
    </body>
</html>

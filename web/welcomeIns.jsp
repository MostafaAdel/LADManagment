<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Instructor MainPage</title>
        <link href="assets/bootstrap.min.css" rel="stylesheet">
        <link href="assets/starter-template.css" rel="stylesheet">

    </head>
    <body>
        
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <center> <h1><font color="white"> Lab Management System</font></h1></center>
            </div>
        </nav><br/><br/><br/><br/><br/>
    <center>
        <div class="group-btn" style="margin-left: 250px;">
            <h1>Select Group </h1>
            <input class="btn" value="EWD" type="button"/>
            <input class="btn" value="MAD" type="button"/>
            <c:out value='${sessionScope.x}'/>
            <c:forEach var="group" items='${sessionScope.insGroups}'>
             <c:out value="${group.name}"></c:out>
            </c:forEach>
        </div>
        <div class="group-btn">
            <h1>Select Course </h1>
            <input class="btn" value="JAVA" type="button"/>
            <input class="btn" value="OPP" type="button"/>
        </div>
    </center>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>

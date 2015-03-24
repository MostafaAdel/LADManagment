<%-- 
    Document   : welcomeStudent
    Created on : Mar 23, 2015, 11:22:02 PM
    Author     : Mostafa_ITI
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/studentStyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1><c:out value="${labDto.name}" ></c:out></h1> 
        
        <div class="queues">
            <div class="deliveryQueue">
                <textarea class="delivery">
                
                </textarea>
                <br>
                <br>
                <center><input type="button" value="Request Delivery" class="button"/> </center>
            </div>

            <div class="assesmentQueue">
                <textarea class="assesment">
                
                </textarea>
                <br>
                <br>
                <center><input type="button" value="Request Assesment" class="button"/> </center>
            </div>
        </div>
    </body>
</html>

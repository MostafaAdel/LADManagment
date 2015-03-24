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
        <title><c:out value="${labDto.name}" ></c:out></title>
        </head>
        <script>
            var assmentReuests = null;

            function sendMessage() {

                if (window.XMLHttpRequest) {
                    assmentReuests = new XMLHttpRequest();
                }
                assmentReuests.onreadystatechange = handelReq;
                uname = document.getElementById("username").value;
                assmentReuests.open("GET", "AssessmentQueueServelt?uname=" + uname, true);
                assmentReuests.send(null);
                document.getElementById("assesmentQueue").value = "";
            }

            function handelReq() {
                if (assmentReuests.readyState == 4) {
                    document.getElementById("assesmentQueue").value = assmentReuests.responseText;
                }
            }
        </script>

        <body onload="setInterval('sendMessage()',2000)" >

            <h1><c:out value="${studentDto.userName}" ></c:out></h1> 
        <input hidden="reuest" id="username" value="${studentDto.userName}">
        <div class="queues">
            <div class="deliveryQueue">
                <textarea class="delivery">
                
                </textarea>
                <br>
                <br>
                <center><input type="button" value="Request Delivery" class="button" onclick=""/> </center>
            </div>

            <div class="assesmentQueue">
                <textarea class="assesment" id="assesmentQueue">
                
                </textarea>
                <br>
                <br>
                <center><input type="button" value="Request Assesment" class="button"/> </center>
            </div>
        </div>
    </body>
</html>

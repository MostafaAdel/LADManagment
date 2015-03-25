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
        <script>
            var request2;
            function getCourses(groupId){
                if (window.XMLHttpRequest)
                {
                    request2=new XMLHttpRequest();
                }
                else if(window.ActiveXObject)
                {
                    request2 =new ActiveXObject("Microsoft.XMLHTTP");
                }
                
                request2.onreadystatechange = updateCourses;
                
                request2.open('GET','/LADManagment/courseBoundary?timeStamp='+new Date().getTime()+"&group="+groupId,true);

                request2.send(null);
            }
            
            function updateCourses(){
                if(request2.readyState == 4){
                    
                    document.getElementById("coursesDiv").innerHTML="";
                    
                    var xmlDoc = request2.responseXML;
                    var messages = xmlDoc.getElementsByTagName("course");
                    for(var i=0 ; i<messages.length ; i++){
                        currentCourse = messages[i];
                        
                        var out2 = currentCourse.childNodes[0].childNodes[0].nodeValue;
                        
                        var hyperLink = document.createElement("a");
                        hyperLink.href="/LADManagment/LapPageInitiator?group="+currentCourse.childNodes[1].childNodes[0].nodeValue
                                                         +"&course="+out2;
                        
                        
                        var button = document.createElement("input");
                        button.className = "btn";
                        button.type="button";
                        button.value=out2;
                        
                        hyperLink.appendChild(button);
                        
                        document.getElementById("coursesDiv").appendChild(hyperLink);
                    }
                }
            }
        </script>
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
            <c:forEach var="group" items='${sessionScope.insGroups}'>
                <input class="btn" value="${group.name}" type="button" onclick="getCourses(${group.groupId})"/>
            </c:forEach>
        </div>
        <div class="group-btn">
            <h1>Select Course </h1>
            <div  id="coursesDiv">
                
            </div>
<!--            <input class="btn" value="JAVA" type="button"/>
            <input class="btn" value="OPP" type="button"/>-->
        </div>
    </center>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>

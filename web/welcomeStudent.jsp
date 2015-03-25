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
            var deliveryReuests = null;
            var addDilveryRequest = null;
            var addAssesstmentRequest = null;
            var cancelDilveryRequest = null;
            var cancelAssessmentRequest = null;
//            function addDeliveryReuest() {
//
//
//            }
            function deliveryQueue() {
                if (window.XMLHttpRequest) {
                    deliveryReuests = new XMLHttpRequest();
                }
                deliveryReuests.onreadystatechange = handelReq;
                uname = document.getElementById("username").value;
                deliveryReuests.open("GET", "DeliveryQueueServelt?uname=" + uname, true);
                deliveryReuests.send(null);
                document.getElementById("deliveryQueue").value = "";
            }

            function handelReq() {
                if (deliveryReuests.readyState == 4) {
                    document.getElementById("deliveryQueue").value = deliveryReuests.responseText;
                }
            }



            function AssessmentQueue() {

                if (window.XMLHttpRequest) {
                    assmentReuests = new XMLHttpRequest();
                }
                assmentReuests.onreadystatechange = handelReq2;
                uname = document.getElementById("username").value;
                assmentReuests.open("GET", "AssessmentQueueServelt?uname=" + uname, true);
                assmentReuests.send(null);
                document.getElementById("assesmentQueue").value = "";
            }

            function handelReq2() {
                if (assmentReuests.readyState == 4) {
                    document.getElementById("assesmentQueue").value = assmentReuests.responseText;
                    ;
                }
            }

            function updateQueues() {
                deliveryQueue();
                AssessmentQueue();
            }

        </script>

        <body onload="setInterval('updateQueues()', 10000)">
            <div class = "upload">
                <input type="file" value="Update Assignments" class="button" disabled="true" />
            </div>
            <br><br>
        <h1><c:out value="${studentDto.fulName}" ></c:out></h1> 
        <input hidden="reuest" id="username" value="${studentDto.userName}">
        <div class="queues">
            <div class="deliveryQueue">
                <center><h2>Delivery Queue</h2></center>
                <textarea class="delivery" id="deliveryQueue" disabled="true">
                
                </textarea>
                <br>
                <br>
                <center>
                    <input type="button" value="Request" class="button" id="wael"/>

                    <script>
//                         
                        document.getElementById("wael").addEventListener("click", function () {
                            if (window.XMLHttpRequest) {
                                addDilveryRequest = new XMLHttpRequest();
                            }
                            addDilveryRequest.open("GET", "AddDeliveryRequest?studentID=" + ${studentDto.studentId} + "&labName=${labDto.name}", true);
                            addDilveryRequest.send(null);
                        });
                    </script>
                    <input type="button" value="Cancel" id="btn_cancele_del_req" class="button" onclick=""/>
                </center>
                <script>
//                         
                    document.getElementById("btn_cancele_del_req").addEventListener("click", function () {
                        if (window.XMLHttpRequest) {
                            cancelDilveryRequest = new XMLHttpRequest();
                        }
                        cancelDilveryRequest.open("GET", "CancelDeliveryRequest?studentID=" + ${studentDto.studentId} + "&labName=${labDto.name}", true);
                        cancelDilveryRequest.send(null);
                    });
                </script>
            </div>

            <div class="assesmentQueue">
                <center><h2>Assessment Queue</h2></center>
                <textarea class="assesment" id="assesmentQueue" disabled="true">
                
                </textarea>
                <br>
                <br>
                <center>
                    <input type="button" value="Request" class="button" id="btn_ass_req"/> 
                    <script>
//                         
                        document.getElementById("btn_ass_req").addEventListener("click", function () {
                            if (window.XMLHttpRequest) {
                                addAssesstmentRequest = new XMLHttpRequest();
                            }
                            addAssesstmentRequest.open("GET", "AddAssesmentRequest?studentID=" + ${studentDto.studentId} + "&labName=${labDto.name}", true);
                            addAssesstmentRequest.send(null);
                        });
                    </script>
                    <input type="button" value="Cancel" id="btn_cancele_ass_req" class="button"/>
                    <script>
//                         
                        document.getElementById("btn_cancele_ass_req").addEventListener("click", function () {
                            if (window.XMLHttpRequest) {
                                cancelAssessmentRequest = new XMLHttpRequest();
                            }
                            cancelAssessmentRequest.open("GET", "CancelAssesmentRequst?studentID=" + ${studentDto.studentId} + "&labName=${labDto.name}", true);
                            cancelAssessmentRequest.send(null);
                        });
                    </script>
                </center>
            </div>
        </div>

    </body>
</html>

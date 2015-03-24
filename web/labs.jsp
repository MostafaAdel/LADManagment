
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Labs Page</title>
        <link href="assets/bootstrap.min.css" rel="stylesheet">
        <link href="assets/starter-template.css" rel="stylesheet">
        <script type="text/javascript" src="assets/tabber.js"></script>
        <link rel="stylesheet" href="assets/example.css" TYPE="text/css" MEDIA="screen">
        <link rel="stylesheet" href="assets/example-print.css" TYPE="text/css" MEDIA="print">

        <script type="text/javascript">
            document.write('<style type="text/css">.tabber{display:none;}<\/style>');
        </script>

    </head>
    <body>
        <header>
        </header>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <center> <h1><font color="white"> Lab Management System</font></h1></center>
            </div>
        </nav><br/><br/><br/>
        <div class="tabber">
            <div class="tabbertab">
                <h2><a href="/LADManagment/LabsController?lab=1"<c:if test="${param.lab == '1'}"> style="color:#FF0000;"</c:if> >Lab 1</a></h2>
                    <div id="contents">
                        <br/>
                        <center>
                        <input type="button" value="start upload"/>
                        <input type="button" value="Shift Queues"/>
                        <input type="button" value="deactivate lab"/>
                        </center>
                        <br/>
                        <div class="group-btn">
                            <h1>Students List</h1>
                            <ul>
                                <li>
                                    Ahmed Medhat
                                    <input type="button" value="View Uploaded Assignment" disabled/>
                                </li>
                                <li>
                                    Ahmed Mazen
                                    <input type="button" value="View Uploaded Assignment" disabled/>
                                </li>
                                <li>
                                    Ahmed Gabr
                                    <input type="button" value="View Uploaded Assignment" disabled/>
                                </li>
                                <li>
                                    Mohamed Sa3eed
                                    <input type="button" value="View Uploaded Assignment" disabled/>
                                </li>
                                <li>
                                    Mostafa Magdy
                                    <input type="button" value="View Uploaded Assignment" disabled/>
                                </li>
                                <li>
                                    Mohsen
                                    <input type="button" value="View Uploaded Assignment" disabled/>
                                </li>
                                <li>
                                    Asmaa
                                    <input type="button" value="View Uploaded Assignment" disabled/>
                                </li>
                                <li>
                                    Eman
                                    <input type="button" value="View Uploaded Assignment" disabled/>
                                </li>
                            </ul>
                            </div>
                        <div class="group-btn">
                            <h1>Assistance Queue</h1>
                            <ul>
                                <li>
                                    Ahmed Medhat
                                    <a href="/LADManagment/LabsController?notifyAssist=Ahmed Medhat"><input type="button" value="notify"/></a>
                                </li>
                                <li>
                                    Ahmed Mazen
                                    <a href="/LADManagment/LabsController?notifyAssist=Ahmed Medhat"><input type="button" value="notify"/></a>
                                </li>
                                <li>
                                    Ahmed Gabr
                                    <a href="/LADManagment/LabsController?notifyAssist=Ahmed Medhat"><input type="button" value="notify"/></a>
                                </li>
                                <li>
                                    Mohamed Sa3eed
                                    <a href="/LADManagment/LabsController?notifyAssist=Ahmed Medhat"><input type="button" value="notify"/></a>
                                </li>
                                <li>
                                    Mostafa Magdy
                                    <a href="/LADManagment/LabsController?notifyAssist=Ahmed Medhat"><input type="button" value="notify"/></a>
                                </li>
                                <li>
                                    Mohsen
                                    <a href="/LADManagment/LabsController?notifyAssist=Ahmed Medhat"><input type="button" value="notify"/></a>
                                </li>
                                <li>
                                    Asmaa
                                    <a href="/LADManagment/LabsController?notifyAssist=Ahmed Medhat"><input type="button" value="notify"/></a>
                                </li>
                                <li>
                                    Eman
                                    <a href="/LADManagment/LabsController?notifyAssist=Ahmed Medhat"><input type="button" value="notify"/></a>
                                </li>
                            </ul>
                            </div>
                        <div class="group-btn">
                            <h1>Delivery Queue</h1>
                            <ul>
                                <li>
                                    Ahmed Medhat
                                    <a href="/LADManagment/LabsController?notifyDelivery=Ahmed Medhat"><input type="button" value="notify"/></a>
                                </li>
                                <li>
                                    Ahmed Mazen
                                    <a href="/LADManagment/LabsController?notifyDelivery=Ahmed Mazen"><input type="button" value="notify"/></a>
                                </li>
                                <li>
                                    Ahmed Gabr
                                    <a href="/LADManagment/LabsController?notifyDelivery=Ahmed Gabr"><input type="button" value="notify"/></a>
                                </li>
                                <li>
                                    Mohamed Sa3eed
                                    <a href="/LADManagment/LabsController?notifyDelivery=Mohamed saeed"><input type="button" value="notify"/></a>
                                </li>
                                <li>
                                    Mostafa Magdy
                                    <a href="/LADManagment/LabsController?notifyDelivery=Mostafa Magdy"><input type="button" value="notify"/></a>
                                </li>
                                <li>
                                    Mohsen
                                    <a href="/LADManagment/LabsController?notifyDelivery=Mohsen"><input type="button" value="notify"/></a>
                                </li>
                                <li>
                                    Asmaa
                                    <a href="/LADManagment/LabsController?notifyDelivery=Asmaa"><input type="button" value="notify"/></a>
                                </li>
                                <li>
                                    Eman
                                    <a href="/LADManagment/LabsController?notifyDelivery=Eman"><input type="button" value="notify"/></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="tabbertab">
                    <h2><a href="/LADManagment/LabsController?lab=2"<c:if test="${param.lab == '2'}"> style="color:#FF0000;"</c:if> >Lab 2</a></h2>
                     <div id="contents">
                        <br/>
                        <center>
                        <input type="button" value="start upload"/>
                        <input type="button" value="Shift Queues"/>
                        <input type="button" value="deactivate lab"/>
                        </center>
                        <br/>
                        <div class="group-btn">
                            <h1>Students List</h1>
                            
                            </div>
                        <div class="group-btn">
                            <h1>Assistance Queue</h1>
                            
                            </div>
                        <div class="group-btn">
                            <h1>Delivery Queue</h1>
                            
                        </div>
                    </div>
                </div>
                <div class="tabbertab">
                    <h2><a href="/LADManagment/LabsController?lab=3"<c:if test="${param.lab == '3'}"> style="color:#FF0000;"</c:if> >Lab 3</a></h2>
                    <div id="contents">
                        <br/>
                        <center>
                        <input type="button" value="start upload"/>
                        <input type="button" value="Shift Queues"/>
                        <input type="button" value="deactivate lab"/>
                        </center>
                        <br/>
                        <div class="group-btn">
                            <h1>Students List</h1>
                            
                            </div>
                        <div class="group-btn">
                            <h1>Assistance Queue</h1>
                            
                            </div>
                        <div class="group-btn">
                            <h1>Delivery Queue</h1>
                            
                        </div>
                    </div>
                </div>
            </div>
       <!-- <a href="/LADManagment/LabsController?lab=1"<c:if test="${param.lab == '1'}"> style="color:#FF0000;"</c:if> >Lab 1</a>
        <a href="/LADManagment/LabsController?lab=2"<c:if test="${param.lab == '2'}"> style="color:#FF0000;"</c:if> >Lab 2</a>
        <a href="/LADManagment/LabsController?lab=3"<c:if test="${param.lab == '3'}"> style="color:#FF0000;"</c:if> >Lab 3</a>-->

        <footer>
        </footer>
    </body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
	<title>Labs Page</title>
</head>
<body>
<!--    LabsController-->
	<header>
	</header>
	<div id="contents">
                <c:forEach var="lab" items='${sessionScope.labs}'>
                    <a href="/LADManagment/labs.jsp?lab=${lab.labId}"<c:if test="${param.lab == lab.labId}"> style="color:#FF0000;"</c:if> >${lab.name}</a>
                </c:forEach>
                    <br/>
		<input type="button" value="start upload"/>
		<input type="button" value="Shift Queues"/>
		<input type="button" value="deactivate lab"/>
		<h3>Students List</h3>
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
		<h3>Assistance Queue</h3>
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
		<h3>Delivery Queue</h3>
		<ul>
			<li>
				Ahmed Medhat
				<a href="/LADManagment/LabsController?notifyDelivery=Ahmed Medhat"><input type="button" valuwe="notify"/></a>
			</li>
			<li>
				Ahmed Mazen
				<a href="/LADManagment/LabsController?notifyDelivery=Ahmed Mazen"><input type="button" valuwe="notify"/></a>
			</li>
			<li>
				Ahmed Gabr
				<a href="/LADManagment/LabsController?notifyDelivery=Ahmed Gabr"><input type="button" valuwe="notify"/></a>
			</li>
			<li>
				Mohamed Sa3eed
				<a href="/LADManagment/LabsController?notifyDelivery=Mohamed saeed"><input type="button" valuwe="notify"/></a>
			</li>
			<li>
				Mostafa Magdy
				<a href="/LADManagment/LabsController?notifyDelivery=Mostafa Magdy"><input type="button" valuwe="notify"/></a>
			</li>
			<li>
				Mohsen
				<a href="/LADManagment/LabsController?notifyDelivery=Mohsen"><input type="button" valuwe="notify"/></a>
			</li>
			<li>
				Asmaa
				<a href="/LADManagment/LabsController?notifyDelivery=Asmaa"><input type="button" valuwe="notify"/></a>
			</li>
			<li>
				Eman
				<a href="/LADManagment/LabsController?notifyDelivery=Eman"><input type="button" valuwe="notify"/></a>
			</li>
		</ul>
	</div>
	<footer>
	</footer>
</body>
</html>
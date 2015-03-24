<<<<<<< HEAD
<%@page import="java.util.Iterator"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Create Group</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    <center><h1>Create Group</h1></center><br><br>
    <form action="../LADManagment/AddGroup" method="GET">
        <table border="0">
            <tbody>
                <tr>
                    <td>Group Name</td>
                    <td> <input type="text" name="groupName" value="" /> </td>
                    <td></td>
                </tr>
                <tr>
                    <td>Course Name: </td>
                    <td> <select id="courseID" name="courseID">
                            <c:forEach var="course" items="${courses}">
                                <option value="${course[0]}"> ${course[1]} </option>
                            </c:forEach>
                        </select> </td>
                    <td></td>
                </tr>
                <tr>
                    <td>Students Track</td>
                    <td>
                        <select id="departmentID" name="departmentID">
                            <c:forEach var="dept" items="${departments}">
                                <option value="${dept[0]}"> ${dept[1]} </option>
                            </c:forEach>
                        </select>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td> <input type="submit" value="Create " /> </td>
                </tr>
            </tbody>
        </table>
    </form>
</body>
</html>
=======
<%@page import="java.util.Iterator"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Create Group</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    <center><h1>Create Group</h1></center><br><br>
    <form action="../LADManagment/AddGroup" method="GET">
        <table border="0">
            <tbody>
                <tr>
                    <td>Group Name</td>
                    <td> <input type="text" name="groupName" value="" /> </td>
                    <td></td>
                </tr>
                <tr>
                    <td>Course Name: </td>
                    <td> <select id="courseID" name="courseID">
                            <c:forEach var="course" items="${courses}">
                                <option value="${course[0]}"> ${course[1]} </option>
                            </c:forEach>
                        </select> </td>
                    <td></td>
                </tr>
                <tr>
                    <td>Students Track</td>
                    <td>
                        <select id="departmentID" name="departmentID">
                            <c:forEach var="dept" items="${departments}">
                                <option value="${dept[0]}"> ${dept[1]} </option>
                            </c:forEach>
                        </select>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td> <input type="submit" value="Create " /> </td>
                </tr>
            </tbody>
        </table>
    </form>
</body>
</html>
>>>>>>> 47d89df5014cd689881c6673ab374229c08df3d6

<%-- 
    Document   : InitilazieGroup
    Created on : Mar 23, 2015, 1:16:36 PM
    Author     : Mostafa_ITI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../css/Adminstyle.css">
        <title>Create Group</title>
    </head>
    <body>
        <h1>Create Group</h1>
        <br>
        <form action="../AddGroup" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Group Name:</td>
                        <td> <input type="text" name="groupName" class ="inputs" placeholder="Group Name ..." size="25" /> </td>
                        <td> <input type="submit" value="Inialize Group Name" class="button" /> </td>
                    </tr>
                </tbody>
            </table>
        </form>

    </body>
</html>

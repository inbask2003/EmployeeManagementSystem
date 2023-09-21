
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Management System</title>
    </head>
    <body>
        <h1>Delete Employee</h1>
        <form action = "DeleteServlet" method="POST">
           <label for = "employeeId">Employee Id</label>
           <input type="text" id = "employeeId" name="employeeId" required>
           <br><br>
           <input type="submit" value ="Delete">
           <a href="index.jsp">Back</a>
        </form>    
    
    </body>
</html>

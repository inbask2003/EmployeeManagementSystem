


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Management System</title>
    </head>
    <body>
        <h1>Add Employee</h1>
        <form action="AddServlet" method="POST">
            <label for = "employeeId">Employee Id</label>
            <input type = "text" id = "employeeId" name = "employeeId" required><br><br>
            <label for = "employeeName">Employee Name</label>
            <input type = "text" id = "employeeName" name = "employeeName" required><br><br> 
            <label for = "employeePhone">Employee Phone</label>
            <input type ="text" id = "employeePhone" name = "employeePhone" required><br><br> 
            <label for = "employeeAddress">Employee Address</label>
            <input type = "text" id = "employeeAddress" name = "employeeAddress" required><br><br>
            <button>Submit</button>
            <a href="index.jsp">Back</a>
        </form>
    </body>
</html>

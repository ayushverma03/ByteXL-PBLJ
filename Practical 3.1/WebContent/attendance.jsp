<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Attendance</title>
</head>
<body>
    <h2>Student Attendance Form</h2>
    <form action="AttendanceServlet" method="POST">
        Student ID: <input type="text" name="studentId" required><br><br>
        Date: <input type="date" name="date" required><br><br>
        Status: 
        <select name="status">
            <option value="Present">Present</option>
            <option value="Absent">Absent</option>
        </select><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>

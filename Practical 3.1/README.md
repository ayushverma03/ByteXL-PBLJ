# JAVA Experiment 3.1 - Java Web Applications with Servlets and JSP

## Part A - User Login
- Open `login.html` in browser via Tomcat server
- Enter credentials: username=admin, password=admin123
- LoginServlet validates and displays welcome message

## Part B - Employee Records
- EmployeeServlet fetches all or specific employee records using JDBC
- Database: `Employee(EmpID, Name, Salary)`

## Part C - Student Attendance
- JSP page `attendance.jsp` collects attendance data
- AttendanceServlet stores it in database
- Database: `Attendance(StudentID, Date, Status)`

## Deployment
- Use Apache Tomcat (9+)
- Place project in `webapps/`
- Include JDBC driver in `WEB-INF/lib/`
- Start Tomcat and access via browser

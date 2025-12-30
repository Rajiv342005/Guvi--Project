<%
    if (session == null || session.getAttribute("role") == null ||
        !"STUDENT".equals(session.getAttribute("role"))) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Student Dashboard</title>
</head>
<body>

<h2>Welcome Student</h2>
<a href="<%= request.getContextPath() %>/student/courses">
    View Available Courses
</a>
<br><br>
<a href="<%= request.getContextPath() %>/student/enrolled">
    My Enrolled Courses
</a>
<br><br>
<a href="<%= request.getContextPath() %>/student/progress">
    My Progress
</a>
<p>Email: <%= session.getAttribute("email") %></p>

<a href="logout">Logout</a>

</body>
</html>


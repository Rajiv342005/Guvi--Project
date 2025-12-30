<%
    if (session == null || session.getAttribute("role") == null ||
        !"INSTRUCTOR".equals(session.getAttribute("role"))) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<%@ page import="java.util.*, com.lms.model.Course" %>

<!DOCTYPE html>
<html>
<head>
    <title>Instructor Dashboard</title>
</head>
<body>

<h2>Welcome Instructor</h2>
<h3>My Courses</h3>

<table border="1" cellpadding="10">
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Status</th>
    </tr>

<%
    List<Course> courses = (List<Course>) request.getAttribute("courses");
    if (courses != null) {
        for (Course c : courses) {
%>
    <tr>
        <td><%= c.getTitle() %></td>
        <td><%= c.getDescription() %></td>
        <td><%= c.getStatus() %></td>
    </tr>
<%
        }
    }
%>
</table>

<br>
<a href="<%= request.getContextPath() %>/instructor/courses">Refresh</a>

<p>Email: <%= session.getAttribute("email") %></p>

<a href="logout">Logout</a>

</body>
</html>


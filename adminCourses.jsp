<%@ page import="java.util.*, com.lms.model.Course" %>
<%
    if (session == null || !"ADMIN".equals(session.getAttribute("role"))) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Course Approval</title>
</head>
<body>

<h2>Pending Courses</h2>

<table border="1" cellpadding="10">
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Instructor ID</th>
        <th>Action</th>
    </tr>

<%
    List<Course> courses = (List<Course>) request.getAttribute("courses");
    if (courses != null) {
        for (Course c : courses) {
%>
    <tr>
        <td><%= c.getTitle() %></td>
        <td><%= c.getDescription() %></td>
        <td><%= c.getInstructorId() %></td>
        <td>
            <a href="<%= request.getContextPath() %>/approveCourse?id=<%= c.getId() %>">Approve</a>
            |
            <a href="<%= request.getContextPath() %>/rejectCourse?id=<%= c.getId() %>">Reject</a>
        </td>
    </tr>
<%
        }
    }
%>
</table>

<br>
<a href="admin/users">Back to Admin Dashboard</a>

</body>
</html>

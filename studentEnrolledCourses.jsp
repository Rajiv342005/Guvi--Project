<%@ page import="java.util.*, com.lms.model.Course" %>
<%
    if (session == null || !"STUDENT".equals(session.getAttribute("role"))) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<h2>My Enrolled Courses</h2>

<table border="1" cellpadding="10">
<tr>
    <th>Course Title</th>
    <th>Description</th>
    <th>Status</th>
</tr>

<%
    List<Course> courses = (List<Course>) request.getAttribute("courses");
    if (courses == null || courses.isEmpty()) {
%>
<tr>
    <td colspan="3">You have not enrolled in any courses yet.</td>
</tr>
<%
    } else {
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

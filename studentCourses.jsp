<%@ page import="java.util.*, com.lms.model.Course" %>
<%
    if (session == null || !"STUDENT".equals(session.getAttribute("role"))) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<h2>Available Courses</h2>

<table border="1" cellpadding="10">
<tr>
    <th>Title</th>
    <th>Description</th>
    <th>Action</th>
</tr>

<%
    List<Course> courses = (List<Course>) request.getAttribute("courses");
    for (Course c : courses) {
%>
<tr>
    <td><%= c.getTitle() %></td>
    <td><%= c.getDescription() %></td>
    <td>
        <a href="<%= request.getContextPath() %>/enrollCourse?id=<%= c.getId() %>">
            Enroll
        </a>
    </td>
</tr>
<%
    }
%>
</table>

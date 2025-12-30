<%@ page import="java.sql.*" %>
<%
    if (session == null || !"STUDENT".equals(session.getAttribute("role"))) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<h2>My Learning Progress</h2>

<table border="1" cellpadding="10">
<tr>
    <th>Course</th>
    <th>Completion (%)</th>
</tr>

<%
    ResultSet rs = (ResultSet) request.getAttribute("progress");
    while (rs != null && rs.next()) {
%>
<tr>
    <td><%= rs.getString("title") %></td>
    <td><%= rs.getInt("completed_percentage") %>%</td>
</tr>
<%
    }
%>
</table>

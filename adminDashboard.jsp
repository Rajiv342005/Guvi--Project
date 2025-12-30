<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    if (session == null || session.getAttribute("role") == null ||
        !"ADMIN".equals(session.getAttribute("role"))) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<%@ page import="java.util.*, com.lms.model.User" %>


<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
</head>
<body>

<h2>Welcome Admin</h2>
<a href="addUser.jsp">➕ Add New User</a>
<br><br>
<h3>All Users</h3><br>
<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Role</th>
        <th>Action</th>
        <th>Action</th>
    </tr>

<%
    List<User> users = (List<User>) request.getAttribute("users");
    if (users != null) {
        for (User u : users) {
%>
    <tr>
    <td><%= u.getId() %></td>
    <td><%= u.getName() %></td>
    <td><%= u.getEmail() %></td>
    <td><%= u.getRole() %></td>
    <td>
    <a href="<%= request.getContextPath() %>/editUser.jsp?id=<%= u.getId() %>">Edit</a> |
    <a href="<%= request.getContextPath() %>/deleteUser?id=<%= u.getId() %>"
       onclick="return confirm('Are you sure you want to delete this user?');">
       Delete
    </a>
</td>
</tr>

<%
        }
    }
%>
</table>
<p>Email: <%= session.getAttribute("email") %></p>

<a href="logout">Logout</a>

</body>
</html>


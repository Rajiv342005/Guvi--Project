<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    if (session == null || !"ADMIN".equals(session.getAttribute("role"))) {
        response.sendRedirect("login.jsp");
        return;
    }

    int id = Integer.parseInt(request.getParameter("id"));

    Connection con = com.lms.util.DBConnection.getConnection();
    PreparedStatement ps = con.prepareStatement(
        "SELECT name, email, role FROM users WHERE id=?"
    );
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();
    rs.next();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit User</title>
</head>
<body>

<h2>Edit User</h2>

<form action="<%= request.getContextPath() %>/updateUser" method="post">
    <input type="hidden" name="id" value="<%= id %>">

    <label>Name:</label><br>
    <input type="text" name="name" value="<%= rs.getString("name") %>" required><br><br>

    <label>Email:</label><br>
    <input type="email" name="email" value="<%= rs.getString("email") %>" required><br><br>

    <label>Role:</label><br>
    <select name="role">
        <option value="ADMIN" <%= "ADMIN".equals(rs.getString("role")) ? "selected" : "" %>>Admin</option>
        <option value="INSTRUCTOR" <%= "INSTRUCTOR".equals(rs.getString("role")) ? "selected" : "" %>>Instructor</option>
        <option value="STUDENT" <%= "STUDENT".equals(rs.getString("role")) ? "selected" : "" %>>Student</option>
    </select><br><br>

    <button type="submit">Update User</button>
</form>

<br>
<a href="admin/users">Back</a>

</body>
</html>

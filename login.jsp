<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>LMS Login</title>
</head>
<body>

<h2>Login</h2>

<form action="login" method="post">
    <label>Email:</label><br>
    <input type="email" name="email" required><br><br>

    <label>Password:</label><br>
    <input type="password" name="password" required><br><br>

    <button type="submit">Login</button>
</form>

<%
    String error = request.getParameter("error");
    if (error != null) {
%>
    <p style="color:red;">Invalid email or password</p>
<%
    }
%>

</body>
</html>

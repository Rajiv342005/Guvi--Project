<%
    if (session == null || !"INSTRUCTOR".equals(session.getAttribute("role"))) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Create Course</title>
</head>
<body>

<h2>Create New Course</h2>

<form action="<%= request.getContextPath() %>/createCourse" method="post">

    <label>Course Title:</label><br>
    <input type="text" name="title" required><br><br>

    <label>Description:</label><br>
    <textarea name="description" required></textarea><br><br>

    <label>Syllabus:</label><br>
    <textarea name="syllabus" required></textarea><br><br>

    <button type="submit">Create Course</button>
</form>

<br>
<a href="instructorDashboard.jsp">Back</a>

</body>
</html>

<html>
<head>
    <title>View Crime Record</title>
</head>
<body bgcolor="lightgreen">
<h2 align="center">View Crime Record</h2>
<form action="MainServlet" method="post">
    <input type="hidden" name="operation" value="viewRecord">
    Case Title: <input type="text" name="caseTitle" required><br><br>
    Crime Date: <input type="date" name="crimeDate" required><br><br>
    <input type="submit" value="View Crime">
</form>
</body>
</html>

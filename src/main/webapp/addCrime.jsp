<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Crime Record</title>
</head>
<body bgcolor="lightcyan">
<h2 align="center">Add Crime Record</h2>
<form action="MainServlet" method="post">
<input type="hidden" name="operation" value="newRecord">
Case Title: <input type="text" name="caseTitle" required><br><br>
Suspect Name: <input type="text" name="suspectName" required><br><br>
Crime Type: <input type="text" name="crimeType" required><br><br>
Crime Date: <input type="date" name="crimeDate" required><br><br>
Location: <input type="text" name="location"><br><br>
Remarks: <input type="text" name="remarks"><br><br>
<input type="submit" value="Add Crime">
</form>
</body>
</html>
<%@ page import="com.wipro.crime.bean.CrimeBean" %>
<html>
<head>
    <title>Crime Details</title>
</head>
<body bgcolor="lightpink">
<h2 align="center">Crime Record Details</h2>
<%
    CrimeBean bean = (CrimeBean) request.getAttribute("crime");
    String msg = (String) request.getAttribute("msg");
    if (bean == null) {
%>
        <h3 align="center"><%= msg %></h3>
<%
    } else {
%>
<table border="1" align="center" cellpadding="10">
    <tr><th>Case ID</th><td><%= bean.getCaseId() %></td></tr>
    <tr><th>Case Title</th><td><%= bean.getCaseTitle() %></td></tr>
    <tr><th>Suspect Name</th><td><%= bean.getSuspectName() %></td></tr>
    <tr><th>Crime Type</th><td><%= bean.getCrimeType() %></td></tr>
    <tr><th>Crime Date</th><td><%= bean.getCrimeDate() %></td></tr>
    <tr><th>Location</th><td><%= bean.getLocation() %></td></tr>
    <tr><th>Remarks</th><td><%= bean.getRemarks() %></td></tr>
</table>
<%
    }
%>
<br><br>
<center><a href="menu.html">Back to Menu</a></center>
</body>
</html>
<%@ page import="java.util.List" %>
<%@ page import="com.wipro.crime.bean.CrimeBean" %>
<html>
<head>
    <title>All Crime Records</title>
</head>
<body bgcolor="lightyellow">
<h2 align="center">All Crime Records</h2>
<%
    List<CrimeBean> list =
            (List<CrimeBean>) request.getAttribute("crimeList");

    String msg = (String) request.getAttribute("msg");

    if (list == null || list.isEmpty()) {
%>
        <h3 align="center"><%= msg %></h3>
<%
    } else {
%>
<table border="1" align="center" cellpadding="10">
    <tr>
        <th>Case ID</th>
        <th>Case Title</th>
        <th>Suspect Name</th>
        <th>Crime Type</th>
        <th>Crime Date</th>
        <th>Location</th>
        <th>Remarks</th>
    </tr>
<%
    for (CrimeBean bean : list) {
%>
    <tr>
        <td><%= bean.getCaseId() %></td>
        <td><%= bean.getCaseTitle() %></td>
        <td><%= bean.getSuspectName() %></td>
        <td><%= bean.getCrimeType() %></td>
        <td><%= bean.getCrimeDate() %></td>
        <td><%= bean.getLocation() %></td>
        <td><%= bean.getRemarks() %></td>
    </tr>
<%
    }
%>
</table>
<%
    }
%>
<br><br>
<center><a href="menu.html">Back to Menu</a></center>
</body>
</html>
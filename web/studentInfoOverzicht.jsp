<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.domain.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="model.db.DatabaseStudent" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Info: Overzicht</title>
</head>
<body>
<table class="tabel">
    <a href="servlet?task=home">back</a>
    <thead>
    <th>achternaam</th>
    <th>voornaam</th>
    <th>richting</th>
    <th>leeftijd</th>
    </thead>
    <c:forEach var="Student" items="${db}">
        <tr>
            <td><p>${Student.naam}</p></td>
            <td><p>${Student.voornaam}</p></td>
            <td><p>${Student.studierichting}</p></td>
            <td><p>${Student.leeftijd}</p></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

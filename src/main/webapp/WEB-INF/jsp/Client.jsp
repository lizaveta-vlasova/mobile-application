<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/hello/client">
</head>
<body>
<h1>CLient list</h1>
<c:if test="${!empty clientList}">
    <table>
        <tr>
            <th width="80">Id</th>
            <th width="120">first_name</th>
            <th width="120">second_name</th>
            <th width="120">date_of_birth</th>
            <th width="120">passport_number</th>
            <th width="120">adress</th>
            <th width="120">contracts_number</th>
            <th width="120">email</th>
            <th width="120">password</th>
        </tr>
        <c:forEach items="${clientList}" var="client">
            <tr>
                <td>${client.id}</td>
                <td>${client.first_name}</td>
                <td>${client.second_name}</td>
                <td>${client.date_of_birth}</td>
                <td>${client.passport_number}</td>
                <td>${client.address}</td>
                <%--<td>${client.contracts_number}</td>--%>
                <td>${client.email}</td>
                <td>${client.password}</td>

            </tr>

        </c:forEach>
    </table>
</c:if>
</body>
</html>

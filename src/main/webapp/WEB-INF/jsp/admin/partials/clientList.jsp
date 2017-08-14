<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="clientList">
    <table class="table table-hover" id="clientList">
        <thead>
        <th>#</th>
        <th>ИМЯ</th>
        <th>ФАМИЛИЯ</th>
        <th>ДАТА РОЖДЕНИЯ</th>
        <th>EMAIL</th>
        <th>ПАСПОРТ</th>
        <th>АДРЕС</th>
        </thead>
        <tbody>
        <tr>
<c:if test="${!empty clientList }">

    <c:forEach items="${clientList}" var="client">
            <th scope="row">${client.id}</th>
        <td>${client.first_name}</td>
        <td>${client.second_name}</td>
        <td>${client.date_of_birth}</td>
        <td>${client.email}</td>
        <td>${client.passport_number}</td>
        <td>${client.address}</td></tr>
    </c:forEach>
        </c:if>
        </tbody>
    </table>

</div>

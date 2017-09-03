<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="clientList">
    <table class="table table-striped" id="clientList">
        <thead>
        <th style="text-align: center;">ID</th>
        <th style="text-align: center;">ИМЯ</th>
        <th style="text-align: center;">ФАМИЛИЯ</th>
        <th style="text-align: center;">ДАТА РОЖДЕНИЯ</th>
        <th style="text-align: center;">EMAIL</th>
        <th style="text-align: center;">ПАСПОРТ</th>
        <th style="text-align: center;">АДРЕС</th>
        </thead>
        <tbody>
        <tr>
<c:if test="${!empty clientList }">

    <c:forEach items="${clientList}" var="client">
            <th scope="row">${client.id}</th>
        <td style="text-align: center;">${client.first_name}</td>
        <td style="text-align: center;">${client.second_name}</td>
        <td style="text-align: center;">${client.date_of_birth}</td>
        <td style="text-align: center;">${client.email}</td>
        <td style="text-align: center;">${client.passport_number}</td>
        <td style="text-align: center;">${client.address}</td></tr>
    </c:forEach>
        </c:if>
        </tbody>
    </table>

</div>

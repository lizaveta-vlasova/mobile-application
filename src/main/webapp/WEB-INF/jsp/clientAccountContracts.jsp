<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <h1>Контракты</h1>

    <c:if test="${!empty client}">
        <p>${client.first_name}
                ${client.second_name}, добро пожаловать!</p>
        <p>В данный момент Вы используете тарифы:</p>
        <ul><c:forEach items="${contractList}" var="contracts">
            <li>${contracts.tariff.name}</li>
        </c:forEach>
        </ul>
    </c:if>
</div>

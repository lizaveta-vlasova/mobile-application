<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div>
    Добавить новый тариф
    <form action="/adminAccount/addTariff/add" method="post">
        Введите название тарифа <p><input type="text" name="name"></p>
        Введите стоимость тарифа <p><input type="text" name="price"></p>
        Выберете опции для подключения <p><c:forEach items="${options}" var="option">
        <input type="checkbox" name="availableOptions" value="${options}">${option.type}</p>
        </c:forEach>
        <p><input type="submit" value="Отправить"></p>
    </form>

</div>


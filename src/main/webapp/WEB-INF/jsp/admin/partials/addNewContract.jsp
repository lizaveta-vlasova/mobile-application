<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>

    <form id="saveNewContract" class="contact_form" action="javascript:void(null);" method="post" onsubmit="saveNewContract()" name="contact_form" >
        <%--@declare id="tariff"--%><%--@declare id="clientid"--%>
            <p><label for="tariff">Выберете тариф:</label>
                <select name="tariff" id="tariffDropDow">
                    <c:forEach items="${tariffList}" var="tariff">
                    <option value="${tariff.id}">${tariff.name}</option>
                </c:forEach></select></p>

            <p><label for="clientId">Выберете клиента по ID</label>
                <select name="clientId" id="clientDropDown">
                    <c:forEach items="${clientList}" var="client">
                    <option value="${client.id}">${client.id}</option>
                </c:forEach></select></p>
            <p>Введите номер: <input type="text" name="number" id="number"></p>
        <p><input type="submit" value="Сохранить" style="height: 30px"></p>
    </form>

</div>

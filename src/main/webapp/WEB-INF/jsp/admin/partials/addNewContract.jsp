<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>



    <form class="form-horizontal" role="form" id="saveNewContract" class="contact_form" action="javascript:void(null);" method="post" onsubmit="saveNewContract()">
        <div class="form-group">
            <%--@declare id="tariff"--%><label for="tariff" class="col-sm-2 control-label" style="width: auto">Выберете тариф</label>
            <div class="col-sm-4">
                <select name="tariff" id="tariffDropDow">
                    <c:forEach items="${tariffList}" var="tariff">
                        <option value="${tariff.id}">${tariff.name}</option>
                    </c:forEach></select>            </div>
        </div>

        <div class="form-group">
            <%--@declare id="clientid"--%><label for="clientId" class="col-sm-2 control-label" style="width: auto">Выберете клиента по ID</label>
            <div class="col-sm-4">
                <select name="clientId" id="clientDropDown">
                    <c:forEach items="${clientList}" var="client">
                        <option value="${client.id}">${client.id}</option>
                    </c:forEach></select>            </div>
        </div>
        <div class="form-group">
            <label for="number" class="col-sm-2 control-label" style="width: auto">Введите номер</label>
            <div class="col-sm-4">
                <input type="text" name="number" id="number"></div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-6">
                <button type="submit" value="Сохранить" id="addTariff">Сохранить</button></div>
        </div>
    </form>

</div>

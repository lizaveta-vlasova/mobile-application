<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>



    <form class="form-horizontal" role="form" id="saveNewContract" class="contact_form" action="javascript:void(null);" method="post" onsubmit="saveNewContract()">
        <div class="form-group">
            <%--@declare id="tariff"--%><label for="tariff" class="col-sm-2 control-label" style="width: auto">Выберете тариф</label>
            <div class="col-sm-4" style="margin-left: 48px; margin-top: 5px">
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
            <%--<label for="number" class="col-sm-2 control-label" style="width: auto">Введите номер</label>
            <div class="col-sm-4" style="margin-left: 59px">
                <input type="text" name="number" id="number"></div>--%>
                <label for="number" class="col-sm-2 control-label">
                    Введите номер
                    <select class="js-example-basic-single" id="number">
                        <option value=""></option>
                        <c:forEach items="${numbers}" var="number">
                            <option value="${number.number}">${number.number}</option>
                        </c:forEach>
                    </select>
                </label>


        </div>

        <select class="js-example-basic-single">
            <option value=""></option>
            <option value="1">New York</option>
            <option value="2">Paris</option>
            <option value="3">London</option>
        </select>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-6">
                <button class="btn btn-info" type="submit" value="Сохранить" id="addTariff">Сохранить</button></div>
        </div>
    </form>

</div>

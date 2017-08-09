<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div style="display: table">
    <div style="display: inline-table">
        <h2>Список тарифов</h2>
        <c:if test="${!empty tariffList}">


            <c:forEach items="${tariffList}" var="tariff">

                <div>
                    <ul>
                        <li> <p>${tariff.name}</p></li>
                        <p>Абонентская плата: ${tariff.price}</p>
                        <p>ID тарифа: ${tariff.id}</p>

                        <div>
                            <button  value="tariffId" onclick="removeTariff(${tariff.id})">Удалить тариф</button>
                        </div></ul>

                </div>
            </c:forEach>
        </c:if>
    </div>
    <div class="addTariff" style="display: inline-table; padding-left: 150px">
   <h2>Добавить новый тариф</h2>
<form id="addTariffForm" class="contact_form" action="javascript:void(null);" method="post" onsubmit="addNewTariff()" name="contact_form" >
    <ul>
        <li><%--@declare id="name"--%><label for="name">Название тарифа:</label><input type="text" name="name" ></li>
        <li><%--@declare id="price"--%><label for="price">Стоимость тарифа:</label><input type="text" name="price"></li>
        <li><input type="submit" value="Сохранить" style="height: auto"></li></ul>
</form>
    </div>
</div>


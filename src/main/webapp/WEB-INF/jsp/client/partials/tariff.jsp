<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div>
    Тарифы

    <c:if test="${!empty tariffList}">
        <c:forEach items="${tariffList}" var="tariff">
            <div class="tariffContainer">
                <div>
                        ${tariff.name}
                </div>
                <div>
                        ${tariff.price}
                </div>
                <div>
                    <c:forEach items="${tariff.availableOptions}" var="tariffOption">
                        <p>${tariffOption.type} ${tariffOption.connectionPrice}
                    </c:forEach>
                </div>
                <div>
                    <c:choose>
                        <c:when test="${currentTariffId == tariff.id}">
                            <button onclick="">Действующий тариф</button>
                        </c:when>
                        <c:otherwise>
                            <button value="tariffId" onclick="showTariffChangeConfirmation(${tariff.id})">Сменить тариф</button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </c:forEach>
    </c:if>

    <div id="myDialog" title="Dialog box">
        <p><span class="ui-icon ui-icon-alert" style="float:left; margin:12px 12px 20px 0;">
        </span>Вы уверены, что хотите перейти на этот тариф?</p>
    </div>


</div>

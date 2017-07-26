<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div>


        <c:if test="${!empty contracts}">
            <c:forEach items="${contracts}" var="contract">
        <select>
            <form action="/adminAccount/blockedClient/${contract.id}" method="get">
            <option value="выберите контракт">Выберите номер контракта</option>

                <option value="contractId">${contract.id}</option>

                <input type="submit" value="Выбрать"/>
            </form>


        </c:forEach>
            </c:if>
        </select>



</div>
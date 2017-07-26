<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div>


    <c:if test="${!empty currentContract}">
    <c:forEach items="${currentContract}" var="contract">
        ${currentContract.id}
        ${currentContract.client}
        ${currentContract.tariff}
    </c:forEach>
    </c:if>

</div>

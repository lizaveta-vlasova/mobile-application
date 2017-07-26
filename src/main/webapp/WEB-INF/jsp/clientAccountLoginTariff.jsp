<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">


<div>
<c:if test="${!empty currentContract}">
    <div>
    <select>ВЫБЕРЕТЕ КОНТРАКТ
        <option value="выберите контракт">Выберите контракт</option>
    <c:forEach items="${currentContract}" var="currentContract">
        <option value="idContract">${currentContract.id}</option>
    </c:forEach>

    </select>
        <button value="idContract" >ок</button>
    </div>

</c:if>
</div>


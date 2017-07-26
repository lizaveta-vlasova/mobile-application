<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div>

    <div >
        <div>
            <p>Заблокировать номер?</p>
        </div>
        <div>
            <c:choose>
                <c:when test="${currentContract.isBlockedByUser == 0}">
                    <button  value="contractId" onclick="blockByUser(${currentContract.id})">Заблокировать номер</button>
                </c:when>
                <c:otherwise>
                    <button value="contractId" onclick="unblockByUser(${currentContract.id})">Разблокировать номер</button>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

</div>

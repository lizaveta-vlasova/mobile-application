<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>

    Для вашего тарифа доступны следующие опции:

    <c:if test="${!empty tariffOptions}">


        <c:forEach items="${tariffOptions}" var="tariffOption">

            <div class="optionContainer" >
                <div>
                       <p>${tariffOption.type}</p>
                </div>
                <div>
                    <c:choose>
                        <c:when test="${currentOptions.contains(tariffOption)}">
                            <button  value="idOption" onclick="deleteOption(${contractId}, ${tariffOption.optionId})">Удалить опцию</button>
                        </c:when>
                        <c:otherwise>
                            <button value="idOption" onclick="addOption(${contractId}, ${tariffOption.optionId})">Добавить опцию</button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </c:forEach>
    </c:if>

</div>
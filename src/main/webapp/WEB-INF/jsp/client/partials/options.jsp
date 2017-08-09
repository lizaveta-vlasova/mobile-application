<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>

    <h2>Для вашего тарифа доступны следующие опции:</h2>

    <c:if test="${!empty tariffOptions}">


        <c:forEach items="${tariffOptions}" var="tariffOption">

            <div class="optionContainer" >
                <ul>
                <div>
                   <li> <h3>${tariffOption.type}</h3>
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
                    </li>  </ul>
            </div>
        </c:forEach>
    </c:if>

</div>
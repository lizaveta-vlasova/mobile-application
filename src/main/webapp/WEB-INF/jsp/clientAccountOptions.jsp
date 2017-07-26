<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <p>Вам используюете следующие опции:</p>
<p><c:if test="${!empty currentOptions}">
            <c:forEach items="${currentOptions}" var="options">
                ${options.type}
        </c:forEach>
        </c:if></p>
</div>

<div>
    <c:if test="${!empty options}">
        <c:forEach items="${options}" var="options">
            <div class="optionContainer">
                <div>
                        ${options.type}
                </div>
                <div>
                        Стоимость${options.price}
                </div>
                <div>
                    <button value="Выбрать опцию" onclick="getContractNumer(${options.optionId})">Выбрать опцию</button>
                </div>
            </div>
        </c:forEach>
    </c:if>

</div>

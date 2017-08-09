<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title>MobileMain</title>
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,300" type="text/css">

    <link href="<c:url value="../../../assets/stylesheets/style.css" />" rel="stylesheet">
    <link href="<c:url value="../../../../assets/lib/jquery-ui.css" />" rel="stylesheet">
    <script src="<c:url value="../../../../assets/lib/jquery-3.2.1.js" />"></script>
    <script src="<c:url value="../../../../assets/lib/jquery-ui.js" />"></script>
    <script src="<c:url value="../../../../assets/javascript/adminAccount.js"/>"></script>
</head>--%>


<div class="optionList">

    Выберете опции для тарифа ${currentTariff.name}
    <c:if test="${!empty options }">


        <c:forEach items="${options}" var="option">

            <div>
                <ul>
                    <div>
                        <li><p>${option.type}</p></li>
                    </div>
                    <div>
                        <c:choose>
                            <c:when test="${currentTariff.availableOptions.contains(option)}">
                            <form id="addOptionsForTariffForm" class="contact_form" action="javascript:void(null);" method="post" onsubmit="addOptionForTariff(${option.optionId}, ${tariffId})" name="contact_form" >

                            <button value="optionId"
                                        onclick="removeOptionForTariff(${option.optionId}, ${tariffId})">Удалить опцию
                                </button>
                            </form>
                            </c:when>
                            <c:otherwise>
                            <form id="addOptionsForTariffForm" class="contact_form" action="javascript:void(null);" method="post" onsubmit="removeOptionForTariff(${option.optionId}, ${tariffId})" name="contact_form" >

                            <button value="optionId" onclick="addOptionForTariff(${option.optionId}, ${tariffId})">
                                    Добавить опцию
                                </button>
                            </form>
                            </c:otherwise>

                        </c:choose>

                    </div>
                </ul>
            </form>
            </div>
        </c:forEach>
    </c:if>
</div>
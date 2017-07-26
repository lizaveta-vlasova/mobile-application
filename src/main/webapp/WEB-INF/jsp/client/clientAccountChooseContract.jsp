<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title>Личный кабинет</title>
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,300" type="text/css">

    <link href="<c:url value="../../assets/stylesheets/style.css" />" rel="stylesheet">
    <script src="<c:url value="../../assets/lib/jquery-3.2.1.js" />"></script>
    <%--<script src="<c:url value="../../assets/javascript/clientAccount.js"/>"></script>--%>
</head>
<body>

<jsp:include page="../header.jsp"/>

<main>
    <div class="clientNAV">
        <aside>
            <nav>
                <ul id="clientNavUl" class="aside-menu">
                    <li id="liCurrentContracts" class="active">
                        МОИ КОНТРАКТЫ
                    </li>
                </ul>
            </nav>
        </aside>
    </div>

    <div id="clientContent" class="clientContent" style="margin-top: -30px">
        <c:if test="${!empty contractsList}">
            <c:forEach items="${contractsList}" var="contract">
                <div class="tariffContainer">
                    <div>
                            ${contract.id}
                    </div>
                    <div>
                            ${contract.tariff.name}
                    </div>
                    <div>
                        <form action="/clientAccount/${contract.id}" method="get">
                            <input type="submit" value="Подробнее"/>
                        </form>
                        <%--<button value="contractId" onclick="location.href='clientAccount'">Подробнее</button>--%>
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </div>
</main>

<jsp:include page="../footer.jsp"/>

</body>
</html>

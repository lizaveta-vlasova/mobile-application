<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title>MobileMain</title>
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,300" type="text/css">

    <link href="<c:url value="../../../assets/stylesheets/style.css" />" rel="stylesheet">
    <link href="<c:url value="../../../assets/lib/jquery-ui.css" />" rel="stylesheet">
    <script src="<c:url value="../../../assets/lib/jquery-3.2.1.js" />"></script>
    <script src="<c:url value="../../../assets/lib/jquery-ui.js" />"></script>
    <script src="<c:url value="../../../assets/javascript/adminAccount.js"/>"></script>
</head>
<body>

<jsp:include page="../header.jsp"/>

<div class="clientNAV">
    <aside>
        <nav>
            <ul id="clientNavUl" class="aside-menu">
                <li id="liClientList">
                    <a onclick="clientList()" href="javascript:void(0)">ВСЕ ПОЛЬЗОВАТЕЛИ</a>
                </li>
                <li id="liAddTariff">
                    <a onclick="addTariff()" href="javascript:void(0)">УПРАВЛЕНИЕ ТАРИФАМИ</a>
                </li>
                <li id="liEditOptions">
                    <a onclick="editOptions()" href="javascript:void(0)">УПРАВЛЕНИЕ ОПЦИЯМИ</a>
                </li>
                <li id="liFindContractPage">
                    <a onclick="findContractPage()" href="javascript:void(0)">НАЙТИ КОНТРАКТ</a>
                </li>
                <li id="liAddNewClient">
                    <a onclick="addNewClient()" href="javascript:void(0)">НОВЫЙ КЛИЕНТ</a>
                </li>
                <li id="liAddNewContract">
                    <a onclick="addNewContract()" href="javascript:void(0)">НОВЫЙ КОНТРАКТ</a>
                </li>

            </ul>
        </nav>
    </aside>
</div>

<div id="adminContent" class="adminContent">
    <h2>Вы находитесь на странице администратора</h2>
</div>

<jsp:include page="../footer.jsp"/>

</body>
</html>

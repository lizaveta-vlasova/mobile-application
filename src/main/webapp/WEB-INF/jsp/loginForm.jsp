<%--
  Created by IntelliJ IDEA.
  User: жюба
  Date: 18.07.2017
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,300" type="text/css">
    <link rel="stylesheet", href="style.css">
    <script>
        <%@include file="../assets/javascript/script.js"%>
    </script>
    <style>
        <%@include file="../assets/stylesheets/style.css"%>
    </style>
    <title>ВХОД В ЛИЧНЫЙ КАБИНЕТ</title>
</head>
<body>
<header>
    <a href="/loginForm"><img src="http://4vector.com/i/free-vector-happy-mobile-logo_124293_jpg/mobile.jpg" width="150" alt="Whitesquare logo"></a>
    <nav>
        <ul class="top-menu">
            <li><a href="/hello/tariff">ВСЕ ТАРИФЫ</a></li>
            <li class="active">О КОМПАНИИ</li>
            <li><a href="/services/">ИНТЕРНЕТ</a></li>
            <li><a href="/partners/">РОУМИНГ</a></li>
            <li><a href="/customers/">ТВ</a></li>
            <li><a href="/projects/">АКЦИИ</a></li>
            <li><a href="/careers/">КОНТАКТЫ</a></li>
            <li><a href="/contact/">КОРПОРАТИВНЫМ КЛИЕНТАМ</a></li>
            <li><a href="/loginForm">ЛИЧНЫЙ КАБИНЕТ</a></li>
        </ul>
    </nav>
</header>
<%--onsubmit="return redirect()"--%>
<div>>
   <%-- <c:url value="/j_spring_security_check" var="loginUrl" />--%>
<form class="form-1"  action="/loginForm{id}" method="get">
    <p class="field">
        <input type="text"  name="idClient" placeholder="Логин">
        <i class="icon-user icon-large"></i>
    </p>
    <p class="field">
        <input type="password" name="password" placeholder="Пароль">
        <i class="icon-lock icon-large"></i>
    </p>
    <p class="submit">
        <button type="submit" name="submit"><i class="icon-arrow-right icon-large"></i></button>
    </p>
</form>
</div>

</body>
</html>

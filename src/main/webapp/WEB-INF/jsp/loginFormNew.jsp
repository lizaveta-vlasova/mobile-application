
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="../../assets/stylesheets/loginFormNew.css"%>
    </style>
    <script>
        <%@include file="../../assets/javascript/script.js"%>
    </script>
    <title>Title</title>
</head>
<body>
<div class="body"></div>
<div class="grad"></div>
<div class="header">
    <div>Вход/<span>Авторизация</span></div>
</div>
<br>
<div class="login">
    <form action="/loginForm{id}" method="get">
    <input type="text" placeholder="username" name="idClient"><br>
    <input type="password" placeholder="password" name="password"><br>
        <button type="submit" name="button" value="Войти">Войти</button>
    </form>
</div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title>MobileMain</title>
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,300" type="text/css">
    <link rel="stylesheet", href="style.css">
    <script>
        <%@include file="../../assets/javascript/script.js"%>
    </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <style>
        <%@include file="../../assets/stylesheets/style.css"%>
    </style>
</head>
<body>
<header>
    <a href="/"><img src="http://4vector.com/i/free-vector-happy-mobile-logo_124293_jpg/mobile.jpg" width="150" alt="Whitesquare logo"></a>
    <nav>
        <ul class="top-menu">
            <li><a href="/hello/tariff">ВСЕ ТАРИФЫ</a></li>
            <li>О КОМПАНИИ</li>
            <li id="int_page"><a href="Internet.jsp"> ИНТЕРНЕТ</a></li>
            <li><a href="">РОУМИНГ</a></li>
            <li><a href="">ТВ</a></li>
            <li><a href="">АКЦИИ</a></li>
            <li><a href="">КОНТАКТЫ</a></li>
            <li><a href="">КОРПОРАТИВНЫМ КЛИЕНТАМ</a></li>
            <li><a href="/loginForm">ЛИЧНЫЙ КАБИНЕТ</a></li>
        </ul>
    </nav>


</header>
<div class="team-row">
    <figure>
        <img src="http://am.cdnmob.org/pic/v2/gallery/preview/arhitektura-mosty-40540.jpg" width="96" height="96" alt="">
        <figcaption>тариф1</figcaption>
    </figure>
    <figure>
        <img src="http://am.cdnmob.org/pic/v2/gallery/preview/kosmos-pejzazh-zvezdy-40562.jpg" width="96" height="96" alt="">
        <figcaption>тариф2</figcaption>
    </figure>
    …
</div>
<div class="team-row">
    <figure>
        <img src="http://am.cdnmob.org/pic/v2/gallery/preview/pejzazh-pustynya-40527.jpg" width="96" height="96" alt="">
        <figcaption>тариф3</figcaption>
    </figure>
    <figure>
        <img src="http://am.cdnmob.org/pic/v2/gallery/preview/cvety-rasteniya-40496.jpg" width="96" height="96" alt="">
        <figcaption>тариф4</figcaption>
    </figure>
    …
</div>
<div class="team-row">
    <figure>
        <img src="http://am.cdnmob.org/pic/v2/gallery/preview/pejzazh-volny-40493.jpg" width="96" height="96" alt="">
        <figcaption>тариф5</figcaption>
    </figure>
    <figure>
        <img src="http://am.cdnmob.org/pic/v2/gallery/preview/pejzazh-pustynya-40458.jpg" width="96" height="96" alt="">
        <figcaption>тариф6</figcaption>
    </figure>
    …
</div>
<div class="team-row">
    <figure>
        <img src="http://am.cdnmob.org/pic/v2/gallery/preview/oblaka-pejzazh-40434.jpg" width="96" height="96" alt="">
        <figcaption>тариф7</figcaption>
    </figure>
    <figure>
        <img src="http://am.cdnmob.org/pic/v2/gallery/preview/oblaka-pejzazh-40434.jpg" width="96" height="96" alt="">
        <figcaption>тариф8</figcaption>
    </figure>
    …
</div>
<footer>
    <div id="footer">
        <div id="sitemap">
            <h3>
                <b>Контакты компании:</b><br>
                Центральный офис: г.Москва, Новоизмайсловский пр. 53, +7-495-576-45-67<br>
                Санкт-Петербург: Лиговский пр. 142, +7-812-545-34-23

            </h3>
        </div>
        <div id="social">
            <h3>Мы в соц. сетях</h3>
            <a href="http://twitter.com/" class="social-icon twitter"></a>
            <a href="http://facebook.com/" class="social-icon facebook"></a>
            <a href="http://plus.google.com/" class="social-icon google-plus"></a>
            <a href="http://vimeo.com/" class="social-icon-small vimeo"></a>
            <a href="http://youtube.com/" class="social-icon-small youtube"></a>
            <a href="http://flickr.com/" class="social-icon-small flickr"></a>
            <a href="http://instagram.com/" class="social-icon-small instagram"></a>
            <a href="/rss/" class="social-icon-small rss"></a>
        </div>
        <div id="footer-logo">
            <a href="/"><img src="https://cdn.dribbble.com/users/555832/screenshots/2316612/dribbble_mobile_service_1.jpg" width="50" alt="MobileService logo"></a>
            <p>Copyright © 2017 MobileService </p>
        </div>
    </div>



</footer>

</body>
</html>
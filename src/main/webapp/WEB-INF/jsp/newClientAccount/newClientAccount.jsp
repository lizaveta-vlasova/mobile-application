<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="../../../clientAccountSettings/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="../../../clientAccountSettings/assets/img/favicon.png">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <title>Личный кабинет</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    <script src="https://code.jquery.com/jquery-migrate-1.4.1.min.js"></script>
    <script type="text/javascript" src="../../../assets/lib/blocksit.js"></script>


    <!-- Bootstrap core CSS     -->
    <link href="../../../clientAccountSettings/assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="../../../clientAccountSettings/assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="../../../clientAccountSettings/assets/css/paper-dashboard.css" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="../../../clientAccountSettings/assets/css/demo.css" rel="stylesheet" />


    <!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="../../../clientAccountSettings/assets/css/themify-icons.css" rel="stylesheet">

</head>
<body>

<div class="wrapper">
    <div class="sidebar" data-background-color="white" data-active-color="danger">

        <!--
            Tip 1: you can change the color of the sidebar's background using: data-background-color="white | black"
            Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
        -->

        <div class="sidebar-wrapper">
            <div class="logo">
                <a href="/">
                    MobileService
                </a>
            </div>

            <ul class="nav" id="clientNavUI">
                <li id="liChooseContract">
                    <a href="/clientAccount/chooseContract">
                        <i class="ti-panel"></i>
                        <p>Ваши контракты</p>
                    </a>
                </li>
                <li id="liUserInformation">
                    <a onclick="userInformation(${contract.client.id})" href="javascript:void(0)">
                        <i class="ti-user"></i>
                        <p>Профиль</p>
                    </a>
                </li>
                <li id="liTariffChange">
                    <c:choose>
                        <c:when test="${isContractBlocked == true}">

                            <a><i class="ti-pencil-alt"></i>
                                <p>Смена тарифа</p></a>
                        </c:when>
                        <c:otherwise>
                            <a onclick="tariffChange(${contractId})" href="javascript:void(0)">
                                <i class="ti-pencil-alt"></i>
                                <p>Смена тарифа</p></a>
                        </c:otherwise>
                    </c:choose>
                </li>
                <li id="liOptionsChange">
                    <c:choose>
                        <c:when test="${isContractBlocked == true}">
                            <a><i class="ti-pencil-alt"></i>
                            <p>Опции</p></a>
                        </c:when>
                        <c:otherwise>
                            <a onclick="optionsChange(${contractId})" href="javascript:void(0)">
                                <i class="ti-pencil-alt"></i>
                                <p>Опции</p></a>
                        </c:otherwise>
                    </c:choose>
                </li>
                <li id="liNumberBlock">
                    <a onclick="numberBlock(${contractId})" href="javascript:void(0)">
                        <i class="ti-unlock"></i>
                        <p>Блокировать номер</p>
                    </a>
                </li>


            </ul>
        </div>
    </div>

    <div class="main-panel">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar bar1"></span>
                        <span class="icon-bar bar2"></span>
                        <span class="icon-bar bar3"></span>
                    </button>
                    <a class="navbar-brand" href="#">${contract.client.first_name} ${contract.client.second_name}, добро пожаловать!</a>
                </div>
                <div class="collapse navbar-collapse">


                </div>
            </div>
        </nav>


        <div class="content" id="content">
            <div class="container-fluid">
                <div class="row">

                    <div class="infoAboutContract">
                        <h2> Вы выбрали контракт для номера ${contract.number}</h2>
                        <c:choose>
                            <c:when test="${isContractBlocked == true}">
                                <h2>Номер заблокирован</h2>
                            </c:when>
                            <c:otherwise>
                                <p>Пожалуйста, выберете действие в боковом меню.</p>
                            </c:otherwise>
                        </c:choose>


                    </div>


                </div>
            </div>
        </div>


        <footer class="footer">
            <div class="container-fluid">
                <nav class="pull-left">
                    <ul>

                        <li>
                            <a href="http://www.creative-tim.com">
                                Creative Tim
                            </a>
                        </li>
                        <li>
                            <a href="http://blog.creative-tim.com">
                                Blog
                            </a>
                        </li>
                        <li>
                            <a href="http://www.creative-tim.com/license">
                                Licenses
                            </a>
                        </li>
                    </ul>
                </nav>
                <div class="copyright pull-right">
                    &copy; <script>document.write(new Date().getFullYear())</script>, made with <i class="fa fa-heart heart"></i> by <a href="http://www.creative-tim.com">Creative Tim</a>
                </div>
            </div>
        </footer>

    </div>
</div>


</body>

<!--   Core JS Files   -->
<script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="../../../clientAccountSettings/assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../../../assets/javascript/clientAccount.js"></script>
<link href="../../../assets/lib/jquery-ui.css" rel="stylesheet">
<script src="../../../assets/lib/jquery-3.2.1.js"></script>
<script src="../../../assets/lib/jquery-ui.js"></script>

<!--  Checkbox, Radio & Switch Plugins -->
<script src="../../../clientAccountSettings/assets/js/bootstrap-checkbox-radio.js"></script>

<!--  Charts Plugin -->
<script src="../../../clientAccountSettings/assets/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="../../../clientAccountSettings/assets/js/bootstrap-notify.js"></script>

<!--  Google Maps Plugin    -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>

<!-- Paper Dashboard Core javascript and methods for Demo purpose -->
<script src="../../../clientAccountSettings/assets/js/paper-dashboard.js"></script>

<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
<script src="../../../clientAccountSettings/assets/js/demo.js"></script>


</html>


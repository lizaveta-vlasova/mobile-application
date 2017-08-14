<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="clientProfile">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >


                <div class="panel panel-info" style="margin-left: -20%; margin-right: 20%">
                    <div class="panel-heading">
                        <h3 class="panel-title">${client.first_name} ${client.second_name}</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class=" col-md-9 col-lg-9 ">
                                <table class="table table-user-information">
                                    <tbody>
                                    <tr>
                                        <td>ID</td>
                                        <td>${client.id}</td>
                                    </tr>
                                    <tr>
                                        <td>Дата рождения:</td>
                                        <td>${client.date_of_birth}</td>
                                    </tr>
                                    <tr>
                                        <td>Номер паспорта</td>
                                        <td>${client.passport_number}</td>
                                    </tr>

                                    <tr>
                                    <tr>
                                        <td>Адрес</td>
                                        <td>${client.address}</td>
                                    </tr>
                                    <tr>
                                        <td>Пароль</td>
                                        <td>${client.password}</td>
                                    </tr>
                                    <tr>
                                        <td>Email</td>
                                        <td>${client.email}</td>
                                    </tr>
                                    <td>Подключенные номера</td>
                                    <c:forEach items="${client.contracts}" var="contract">
                                        <td style="display: block">${contract.number}</td>
                                    </c:forEach>
                                    </tr>

                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>


                </div>
            </div>
        </div>
    </div>
</div>

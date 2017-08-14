<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<div class="demo">
    <div class="container">
        <div class="row">
            <div class="col-md-6" style="width: 100%">
                <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingOne">
                            <h4 class="panel-title">
                                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                    Все тарифы
                                </a>
                            </h4>
                        </div>
                        <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                            <div class="panel-body">
                                <c:if test="${!empty tariffList}">

                                    <c:forEach items="${tariffList}" var="tariff">

                                        <div class="tariffContainer">
                                            <p>${tariff.name}</p>
                                            <p>Абонентская плата: ${tariff.price}</p>
                                            <p>ID тарифа: ${tariff.id}</p>

                                            <div>
                                                <button  value="tariffId" onclick="removeTariff(${tariff.id})">Удалить тариф</button>
                                                <button  value="tariffId" onclick="editTariff(${tariff.id})">Редактировать тариф</button>
                                            </div>

                                        </div>
                                    </c:forEach>
                                </c:if>                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingTwo">
                            <h4 class="panel-title">
                                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                    Добавить новый тариф
                                </a>
                            </h4>
                        </div>
                        <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                            <div class="panel-body">
                                <form class="form-horizontal" role="form" id="addTariffForm" action="javascript:void(null);" method="post" onsubmit="addNewTariff()">
                                    <div class="form-group">
                                        <label for="name" class="col-sm-2 control-label">Название</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="name" name="name" placeholder="Название" required autofocus>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="price" class="col-sm-2 control-label">Абонентская плата</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="price" name="price" placeholder="Стоимость в месяц" required>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-6">
                                            <button type="submit" value="Сохранить" id="addTariff">Сохранить</button></div>
                                    </div>
                                </form>                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>



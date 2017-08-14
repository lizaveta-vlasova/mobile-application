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
                                    Информация о тарифе
                                </a>
                            </h4>
                        </div>
                        <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                            <div class="panel-body">
                                <p class="editTariff">Название тарифа:  <b>${tariff.name}</b></p>
                                <p class="editTariff">Стоимость тарифа: <b>${tariff.price}</b></p>
                                <p class="editTariff">Подключенные опции:
                                    <c:forEach items="${tariff.availableOptions}" var="option">
                                <ul><li>${option.type}</li></ul></c:forEach>                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingTwo">
                            <h4 class="panel-title">
                                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                    Изменение данных
                                </a>
                            </h4>
                        </div>
                        <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                            <div class="panel-body">
                                <form role="form" class="form-inline" id="updateTariff" action="javascript:void(null);" method="post" onsubmit="saveEditTariff(${tariff.id})" style="margin-top: 20px">
                                    <%--@declare id="name"--%><%--@declare id="price"--%>
                                    <div class="form-group"><label for="name">Введите название:</label><input type="text" name="name"></div>

                                    <div class="form-group"> <label for="price">Введите стоимость:</label><input type="text" name="price"></div>

                                    <div class="form-group"> <input type="submit" value="Сохранить"></div>
                                </form>                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="headingThree">
                            <h4 class="panel-title">
                                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                   Добавление/удаление опций для тарифа
                                </a>
                            </h4>
                        </div>
                        <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                            <div class="panel-body">
                                <div class="container" style="margin-top: 40px">
                                    <div class="row">
                                        <c:if test="${!empty optionList}">
                                            <c:forEach items="${optionList}" var="option">
                                                <div class="col-md-4 col-sm-6">
                                                    <div class="serviceBoxEdit">
                                                        <div class="service-icon">
                                                            <i class="fa fa-globe"></i>
                                                        </div>
                                                        <div class="service-content">
                                                            <h3>${option.type}</h3>
                                                        </div>
                                                        <div class="read">
                                                            <c:choose>
                                                                <c:when test="${tariff.availableOptions.contains(option)}">
                                                                    <button  value="idOption" onclick="removeOptionsForTariff(${tariff.id}, ${option.optionId})">Удалить опцию</button>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <button value="idOption" onclick="addOptionsForTariff(${tariff.id}, ${option.optionId})">Добавить опцию</button>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </c:if>                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    </div>
</div>
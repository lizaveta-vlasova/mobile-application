<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div>
    <form id="saveNewClientForm" class="contact_form" action="javascript:void(null);" method="post" onsubmit="saveNewClient()" name="contact_form" >
       <ul>
           <li><%--@declare id="first_name"--%><label for="first_name">Имя:</label><input type="text" name="first_name" ></li>
           <li><%--@declare id="second_name"--%><label for="second_name">Фамилия</label><input type="text" name="second_name"></li>
           <li><%--@declare id="date_of_birth"--%><label for="date_of_birth"> Дата рождения </label><input type="text" name="date_of_birth"></li>
           <li><%--@declare id="passport_number"--%><label for="passport_number"> Номер паспорта</label><input type="text" name="passport_number"></li>
           <li><%--@declare id="address"--%><label for="address">Адрес</label><input type="text" name="address"></li>
           <li><%--@declare id="email"--%><label for="email">Email</label><input type="text" name="email"></li>
           <li><%--@declare id="password"--%><label for="password">Пароль</label><input type="text" name="password"></li>
           <li><input type="submit" value="Отправить" style="height: auto"></li></ul>
    </form>



</div>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div>
    <form action="/adminAccount/addNewClient/add" method="get" >
        Имя <p><input type="text" name="first_name" ></p>
        Фамилия<p><input type="text" name="second_name"></p>
        Дата рождения <p><input type="text" name="date_of_birth"></p>
        Номер паспорта <p><input type="text" name="passport_number"></p>
        Адрес <p><input type="text" name="address"></p>
        Email<p><input type="text" name="email"></p>
        Пароль<p><input type="text" name="password"></p>
        <p><input type="submit" value="Отправить"></p>
    </form>



</div>

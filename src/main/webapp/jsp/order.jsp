<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*,java.sql.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<head>
    <title>Order</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
</head>

<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Make your new order!
    </div>
    <form method="post" action="order">
        <label for="name">Order name
            <input class="input-field" type="text" name="name" id="name">
        </label>
        <label for="color">Order color
            <select class="select-field" name="color" id="color">
                <option hidden selected value></option>
                <option value="red">red</option>
                <option value="green">green</option>
                <option value="blue">blue</option>
            </select>
        </label>
        <label for="cost">Order cost
            <input class="input-field" type="text" name="cost" id="cost">
        </label>
        <input type="submit" value="order">
    </form>
</div>


<sql:setDataSource var="snapshot" driver="org.postgresql.Driver"
                   url="jdbc:postgresql://localhost:5432/db_example"
                   user="postgres" password="admin"/>

<sql:query dataSource="${snapshot}" var="result">
    SELECT purchase.name, purchase.color, purchase.cost from purchase join web_user on purchase.owner_id=web_user.id where web_user.name='${sessionScope.name}'
</sql:query>

<table style="color: ${cookie.color.value}">
    <tr>
        <th>name</th>
        <th>color</th>
        <th>cost</th>
    </tr>

    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td><c:out value="${row.name}"/></td>
            <td><c:out value="${row.color}"/></td>
            <td><c:out value="${row.cost}"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

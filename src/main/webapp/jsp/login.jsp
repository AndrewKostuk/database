<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>

<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Please sign in!
    </div>

    <form method="post" action="login">
        <label for="name">User name
            <input class="input-field" type="text" id="name" name="name">
        </label>

        <label for="password">Password
            <input class="input-field" type="password" id="password" name="password">
        </label>

        <label for="color">
            <select name="color" id="color">
                <option value="red">Красный</option>
                <option value="green">Зеленый</option>
                <option value="blue">Голубой</option>
            </select>
        </label>

        <input type="submit" value="Sign In">
    </form>
</div>
</body>
</html>

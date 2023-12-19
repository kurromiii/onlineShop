
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="/login.do" method="post">
    <label for="usernameId">Username</label>
    <input id="usernameId" type="text" name="username" placeholder="username">

    <label for="passwordId">Password</label>
    <input id="passwordId" type="text" name="password" placeholder="password">

    <label for="rememberId">Remember Me</label>
    <input id="rememberId" type="checkbox" name="remember">

    <input type="submit" value="Login">
</form>
</body>
</html>

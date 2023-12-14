
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form action="/register.do" method="post">
    <label for="nameId">Name</label>
    <input id="nameId" type="text" name="name" placeholder="name">

    <label for="familyId">Family</label>
    <input id="familyId" type="text" name="family" placeholder="family">

    <label for="usernameId">Username</label>
    <input id="usernameId" type="text" name="username" placeholder="username">

    <label for="passwordId">Password</label>
    <input id="passwordId" type="text" name="password" placeholder="password">

    <input type="submit" value="Register">
</form>

</body>
</html>

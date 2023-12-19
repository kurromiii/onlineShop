
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stuff</title>
</head>
<body>
<form action="/stuff.do" method="post">
    <label for="nameId">Name</label>
    <input id="nameId" type="text" name="name" placeholder="name">

    <label for="groupId">Group</label>
    <input id="groupId" type="text" name="group" placeholder="group">

    <label for="brandId">Brand</label>
    <input id="brandId" type="text" name="brand" placeholder="brand">

    <label for="priceId">Price</label>
    <input id="priceId" type="text" name="price" placeholder="price">

    <input type="submit" value="save">
</form>

</body>
</html>

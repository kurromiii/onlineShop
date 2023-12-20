<%@ page import="com.mftplus.onlineshop.model.entity.Stuff" %>
<%@ page import="com.mftplus.onlineshop.model.service.StuffService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<a href="/register.do">register</a>
<br/>
<a href="/login.do">login</a>
<br><br><br><br><br>

<a href="/stuff.do">saveStuff</a>
<br><br><br>

<table width="100%" border="1px" cellspacing="0px" cellpadding="10px">
    <thead>
    <tr>
        <th>Name</th>
        <th>Group</th>
        <th>Brand</th>
        <th>Category</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <%for (Stuff stuff : StuffService.getStuffService().findAll()) {%>
    <form action="/cart.do" method="post">
    <tr class="table-row">
        <td>
            <%=stuff.getName()%>
        </td>
        <td>
            <%=stuff.getGroup()%>
        </td>
        <td>
            <%=stuff.getBrand()%>
        </td>
        <td>
            <%=stuff.getCategory()%>
        </td>
        <td>
            <%=stuff.getPrice()%>
        </td>
        <td style="display: none">
            <input name="stuffId" style="display: none" type="text" value=<%=stuff.getId()%>>
        </td>
        <td style="width: fit-content">
            <input name="count" type="text" placeholder="count">
        </td>
        <td >
            <input type="submit" value="add">
        </td>
    </tr>
    </form>
    <%}%>
    </tbody>
</table>

</body>
</html>
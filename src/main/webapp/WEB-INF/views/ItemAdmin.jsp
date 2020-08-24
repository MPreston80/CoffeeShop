<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1">
    <tr>
        <th>ProductName</th>
        <th>Description</th>
        <th>Quantity</th>
        <th>Price</th>

    </tr>

    <c:forEach var="items" items="${displayItems}">
    <tr>
        <td>${items.productName}</td>
        <td>${items.description}</td>
        <td>${items.quantity}</td>
        <td>${items.price}</td>
        <td><a href="delItem?id=${items.productName}" onclick="return confirm('Are you sure you want to remove this item?')">Delete</a></td>
        <td><a href="editItem?id=${items.productName}">Edit</a></td>



    </tr>
    </c:forEach>

</table>
<br>
<br>
    <a href="addItem">Add a new item</a>

</body>
</html>

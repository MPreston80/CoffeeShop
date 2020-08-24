<%--
  Created by IntelliJ IDEA.
  User: Mike
  Date: 5/21/2017
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><b>Add a new Item</b></p>
<br>

<form action="add" method="post">
    Name: <input type = "text" name = "name"><br>
    Description: <input type = "text" name="description"><br>
    Quantity: <input type = "text" name="qty"><br>
    Price: <input type = "text" name="price"><br>
    Type: <input type = "text" name="type"><br>

    <input type="submit" value="Save">




</form>

</body>
</html>

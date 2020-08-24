<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="display" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="saveEdit" method="post">
    Name <input type="text" name="name" value="${products}"> <br>
    Description <input type="text" name="describe" value="${descs}"> <br>
    Quantity <input type="text" name="qty" value="${qtys}"> <br>
    Price <input type="text" name="price" value="${prices}"><br>
    <input type="hidden" name="id" value="${itemID}"><br>



    <input type="submit" value="Save">

</form>


</body>
</html>

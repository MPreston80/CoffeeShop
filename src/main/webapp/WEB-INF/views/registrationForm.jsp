<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mike
  Date: 2/28/2017
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<form action="processForm" method="post">
    First Name <input type="text" name="Fname"> <br>
    Last Name <input type="text" name="Lname"> <br>
    Gender<input type ="radio" name="gender" value ="male"> Male
          <input type ="radio" name="gender" value ="female"> Female
          <input type ="radio" name="gender" value = "other"> Other<br>
    Email <input type = "email" name="eMail"><br>
    Phone Number <input type = "number" name="phoneNum"><br>
    Password <input type = "password" name="pWord"><br>
    Confirm Password<input type = "password" name="confirmPword"><br>
    Address City, State<input type = "text" name="Address"><br>
    Zip Code<input type = "number" name="Zip"><br>

    <input type="submit" value="Register">


</form>

<form action ="processPhoto" method = "post" enctype="multipart/form-data">
    <input type = "file" name="photo">
    <input type = "submit" value="Add your pic">
</form>

</body>
</html>

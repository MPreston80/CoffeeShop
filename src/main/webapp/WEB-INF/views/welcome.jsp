<%--
  Created by IntelliJ IDEA.
  User: kamel
  Date: 1/12/2017
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

${message}


<!--the action in form is taking you directly to registrationForm request mapping in Home Controller.-->
<form action="registrationForm" method="get">
<input type="submit" value="Register">
<br>
<h2 style="color: midnightblue; font-family: fantasy">COFFEES</h2>

</form>
<div style="display:inline-block;border-style:double;margin-top:5px;margin-bottom:5px;background-color: linen;text-align: center;height:140px;width:170px">
    <p style="font-weight: bold">Columbian Dark Roast</p>

    <p>2 lbs.  Ground Coffee</p>

    <p>$14.50</p>

</div>

<div style="border-style:double;display:inline-block;margin-top:5px;margin-bottom:5px;background-color: lightskyblue;text-align: center;height:140px;width:150px">
    <p style="font-weight: bold">Caramel Pecan Blend</p>

    <p>1 lb. Whole Bean</p>

    <p>$8.50</p>

</div>

<div style="display:inline-block;border-style:double;margin-top:5px;margin-bottom:5px;background-color: mediumvioletred;text-align: center;height:140px;width:170px">
    <p style="font-weight: bold">Chocolate Cherry Blend</p>

    <p>2 lbs.  Ground Coffee</p>

    <p>$16.50</p>

</div>

<div style="display:inline-block;border-style:double;margin-top:5px;margin-bottom:5px;background-color: burlywood;text-align: center;height:140px;width:160px">
    <p style="font-weight: bold">Ethiopian Light Roast</p>

    <p>2 lbs.  Whole Bean</p>

    <p>$18.99</p>

</div>

<div style="display:inline-block;border-style:double;margin-top:5px;margin-bottom:5px;background-color: linen;text-align: center;height:140px;width:200px">
    <p style="font-weight: bold">Costa Rican Paradise Blend</p>

    <p>2 lbs.  Ground Coffee</p>

    <p>$15.50</p>

</div>
<br>


<h2 style="color: midnightblue; font-family: fantasy">MUGS</h2>


<div style="display:inline-block;border-style:double;margin-top:5px;margin-bottom:5px;background-color: linen;text-align: center;height:140px;width:180px">
    <p style="font-weight: bold">Grand Circus Mug</p>

    <p>Holds 24 oz. Charcoal</p>

    <p>$6.50</p>

</div>

<div style="display:inline-block;border-style:double;margin-top:5px;margin-bottom:5px;background-color: mediumvioletred;text-align: center;height:140px;width:170px">
    <p style="font-weight: bold">Grumpy Cat Mug</p>

    <p>Holds 24 oz.  Light Gray</p>

    <p>$6.50</p>

</div>

<div style="display:inline-block;border-style:double;margin-top:5px;margin-bottom:5px;background-color: burlywood;text-align: center;height:140px;width:150px">
    <p style="font-weight: bold">Coffee Addict Mug</p>

    <p>Holds 30 oz.  Black</p>

    <p>$6.50</p>

</div>
<br>


<a href="ItemAdmin">Administrative</a>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/03/2023
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/ket-qua" method="post">

    <div class="container">
        <label for="uname"><b>Username</b></label>
        <input type="text" name="uname">

        <label for="psw"><b>Password</b></label>
        <input type="password" name="psw">

        <button type="submit">Login</button>
        <span>${error}</span>

    </div>

</form>

</body>
</html>

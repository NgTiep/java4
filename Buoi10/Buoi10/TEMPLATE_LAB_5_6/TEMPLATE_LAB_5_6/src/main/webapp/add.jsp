<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/03/2023
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<section class="container">

    <form action="/sinh-vien/add" method="post">
        <label>Ten</label>
        <input type="text" name="ten">

        <label>Tuoi</label>
        <input type="number" name="tuoi">

        <label>Dia Chi</label>
        <input type="text" name="diaChi">

        <label>Gioi Tinh</label>
        <input type="radio" name="gioiTinh" value="true" checked>Nam
        <input type="radio" name="gioiTinh" value="false">Nữ

        <button type="submit">Add</button>
    </form>

</section>

</body>
</html>

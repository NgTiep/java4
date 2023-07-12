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
</head>
<body>

<section class="container">

    <form action="/sinh-vien/update" method="post">

        <label>Ma</label>
        <input type="text" name="ma" value="${sv.ma}">

        <label>Ten</label>
        <input type="text" name="ten" value="${sv.ten}">

        <label>Tuoi</label>
        <input type="number" name="tuoi" value="${sv.tuoi}">

        <label>Dia Chi</label>
        <input type="text" name="diaChi" value="${sv.diaChi}">

        <label>Gioi Tinh</label>
        <input type="radio" name="gioiTinh" value="true" checked ${sv.gioiTinh==true?"checked":""}>Nam
        <input type="radio" name="gioiTinh" value="false" ${sv.gioiTinh==false?"checked":""}>Nữ

        <button type="submit">Update</button>
    </form>

</section>

</body>
</html>

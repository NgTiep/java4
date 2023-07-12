<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/03/2023
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<section class="container">
    <form action="/sinh-vien/detail" method="get">
        <label>Ma: ${sv.ma}</label><br>
        <label>Ten: ${sv.ten}</label><br>
        <label>Tuoi: ${sv.tuoi}</label><br>
        <label>Dia Chi: ${sv.diaChi}</label><br>
        <label>Giới Tính:
            <c:if test="${sv.gioiTinh==true}">Nam</c:if>
            <c:if test="${sv.gioiTinh==false}">Nữ</c:if>
        </label><br>
    </form>
</section>

</body>
</html>

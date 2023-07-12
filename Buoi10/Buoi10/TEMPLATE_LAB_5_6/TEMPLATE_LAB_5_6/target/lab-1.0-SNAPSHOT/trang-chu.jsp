<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 14/03/2023
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>

<section class="container">

    <%--Search--%>
    <form action="/sinh-vien/search" method="get">
        <label>Ten</label>
        <input type="text" name="ten">
        <button type="submit">Search</button>
    </form>

        <button><a href="/sinh-vien/view-add">Add</a></button>


    <%--Table--%>
    <table>
        <tr>
            <th>Ma</th>
            <th>Ten</th>
            <th>Tuoi</th>
            <th>Dia Chi</th>
            <th>Gioi Tinh</th>
            <th>Action</th>
        </tr>
        <tbody>
        <c:forEach items="${listSV}" var="sv">
            <tr>
                <td>${sv.ma}</td>
                <td>${sv.ten}</td>
                <td>${sv.tuoi}</td>
                <td>${sv.diaChi}</td>
                <td>
                    <c:if test="${sv.gioiTinh==true}">Nam</c:if>
                    <c:if test="${sv.gioiTinh==false}">Nữ</c:if>
                </td>
                <td>
                    <button><a href="/sinh-vien/delete?ma=${sv.ma}">Delete</a></button>
                    <button><a href="/sinh-vien/detail?ma=${sv.ma}">Detail</a></button>
                    <button><a href="/sinh-vien/view-update?ma=${sv.ma}">Update</a></button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <label style="color: red">${mess}</label>
</section>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
</body>
</html>
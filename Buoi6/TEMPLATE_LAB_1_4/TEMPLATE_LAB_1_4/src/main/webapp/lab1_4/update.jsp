<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 20/03/2023
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>

<header>Header</header>

<section>
    <%--Form input--%>
        <form action="/san-pham/update" method="post">
            <div class="">
                <label><b>Id</b></label> <br>
                <input type="number" placeholder="id" name="id" value="${sp.id}"> <br>

                <label><b>Ma</b></label> <br>
                <input type="text" placeholder="ma" name="ma" value="${sp.ma}"> <br>

                <label><b>Tên</b></label> <br>
                <input type="text" placeholder="ten" name="ten" value="${sp.ten}"> <br>

                <label><b>Loai</b></label> <br>
                <select class="form-select" name="loai" style="width: 200px">
                    <option selected value="loai 1" ${sp.loai=="loai 1"?"selected":""}>loai 1</option>
                    <option value="loai 2" ${sp.loai=="loai 2"?"selected":""}>loai 2</option>
                    <option value="loai 3" ${sp.loai=="loai 3"?"selected":""}>loai 3</option>
                    <option value="loai 4" ${sp.loai=="loai 4"?"selected":""}>loai 4</option>
                </select>

                <label><b>Gioi Tinh</b></label> <br>
                <input type="radio" name="gioiTinh" value="true" ${sp.gioiTinh==true?"checked":""} checked>Đực
                <input type="radio" name="gioiTinh" value="false" ${sp.gioiTinh==false?"checked":""}>Cái <br>

                <label><b>Gia</b></label> <br>
                <input type="number" placeholder="gia" name="gia" value="${sp.gia}"> <br>
                <button type="submit">Update</button>
            </div>
        </form>
</section>


<footer>Footer</footer>

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

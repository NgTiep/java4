<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/03/2023
  Time: 22:30
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
<header>
    <h3 style="text-align: center;">Thông Tin Chi Tiết</h3>
</header>

<main class="container">
    <section>
        <div class="row mt-4">
            <div class="col-6">
                <label><b>Ma: </b></label>
                <span>${kh.ma}</span>
            </div>
            <div class="col-6">
                <label><b>Ten: </b></label>
                <span>${kh.ten}</span>
            </div>
        </div>

        <div class="row mt-4">
            <div class="col-6">
                <label><b>Ten Dem: </b></label>
                <span>${kh.tenDem}</span>
            </div>
            <div class="col-6">
                <label><b>Ho: </b></label>
                <span>${kh.ho}</span>
            </div>
        </div>

        <div class="row mt-4">
            <div class="col-6">
                <label><b>Ngay Sinh: </b></label>
                <span>${kh.ngaySinh}</span>
            </div>
            <div class="col-6">
                <label><b>SDT: </b></label>
                <span>${kh.sdt}</span>
            </div>
        </div>

        <div class="row mt-4">
            <div class="col-6">
                <label><b>Dia Chi: </b></label>
                <span>${kh.diaChi}</span>
            </div>
            <div class="col-6">
                <label><b>Thanh Pho: </b></label>
                <span>${kh.thanhPho}</span>
            </div>
        </div>

        <div class="row mt-4">
            <div class="col-6">
                <label><b>Quoc Gia: </b></label>
                <span>${kh.quocGia}</span>
            </div>
            <div class="col-6">
                <label><b>Mat Khau: </b></label>
                <span>${kh.matKhau}</span>
            </div>
        </div>


    </section>

</main>
<footer><p style="text-align: center; margin-top: 50px"><b>Tiepnmph25816</b></p></footer>

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

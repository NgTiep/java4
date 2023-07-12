package com.fpt.poly.lab.controller;


import com.fpt.poly.lab.entity.SinhVien;
import com.fpt.poly.lab.service.SinhVienService;
import com.fpt.poly.lab.service.impl.SinhVienServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi",
        "/sinh-vien/delete",
        "/sinh-vien/detail",
        "/sinh-vien/search",
        "/sinh-vien/add",
        "/sinh-vien/update",
        "/sinh-vien/view-add",
        "/sinh-vien/view-update",
})
public class SinhVienServlet extends HttpServlet {
    private SinhVienService sinhVienService = new SinhVienServiceImpl();
    private List<SinhVien> listSinhVien = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThi(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("search")) {
            this.search(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAdd(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdate(request, response);
        } else {
            this.hienThi(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.add(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String diaChi = request.getParameter("diaChi");
        String gioiTinh = request.getParameter("gioiTinh");

        SinhVien sv = SinhVien.builder()
                .ma(UUID.fromString(ma))
                .ten(ten)
                .tuoi(Long.valueOf(tuoi))
                .diaChi(diaChi)
                .gioiTinh(Boolean.valueOf(gioiTinh))
                .build();
        request.setAttribute("mess", sinhVienService.update(sv));
        listSinhVien = sinhVienService.getAll();
        request.setAttribute("listSV", listSinhVien);
        request.getRequestDispatcher("/trang-chu.jsp").forward(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String diaChi = request.getParameter("diaChi");
        String gioiTinh = request.getParameter("gioiTinh");

        SinhVien sv = SinhVien.builder()
                .ten(ten)
                .tuoi(Long.valueOf(tuoi))
                .diaChi(diaChi)
                .gioiTinh(Boolean.valueOf(gioiTinh))
                .build();
        request.setAttribute("mess", sinhVienService.add(sv));
        listSinhVien = sinhVienService.getAll();
        request.setAttribute("listSV", listSinhVien);
        request.getRequestDispatcher("/trang-chu.jsp").forward(request, response);

    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SinhVien sv = sinhVienService.getOne(UUID.fromString(ma));
        request.setAttribute("sv", sv);
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/add.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SinhVien sv = sinhVienService.getOne(UUID.fromString(ma));
        request.setAttribute("sv", sv);
        request.getRequestDispatcher("/detail.jsp").forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("ten");
        listSinhVien = sinhVienService.search(ten);
        request.setAttribute("listSV", listSinhVien);
        request.getRequestDispatcher("/trang-chu.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SinhVien sv = sinhVienService.getOne(UUID.fromString(ma));
        request.setAttribute("mess", sinhVienService.delete(sv));
        listSinhVien = sinhVienService.getAll();
        request.setAttribute("listSV", listSinhVien);
        request.getRequestDispatcher("/trang-chu.jsp").forward(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listSinhVien = sinhVienService.getAll();
        request.setAttribute("listSV", listSinhVien);
        request.getRequestDispatcher("/trang-chu.jsp").forward(request, response);
    }
}

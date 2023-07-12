package com.fpt.poly.lab.controller;


import com.fpt.poly.lab.entity.SanPham;
import com.fpt.poly.lab.service.SanPhamService;
import com.fpt.poly.lab.service.impl.SanPhamServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SanPhamServlet", value = {
        "/san-pham/hien-thi",
        "/san-pham/search",
        "/san-pham/add",
        "/san-pham/update",
        "/san-pham/delete",
        "/san-pham/detail",
        "/san-pham/view-add",
        "/san-pham/view-update",
        "/san-pham/sort-gia",
        "/san-pham/san-pham-cai",
        "/san-pham/loai",
        "/san-pham/view-hien-thi"
})
public class SanPhamServlet extends HttpServlet {
    private SanPhamService sanPhamService = new SanPhamServiceImpl();
    private List<SanPham> listSanPham = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiSanPham(request, response);
        } else if (uri.contains("search")) {
            this.searchSanPham(request, response);
        } else if (uri.contains("delete")) {
            this.deleteSanPham(request, response);
        } else if (uri.contains("detail")) {
            this.detailSanPham(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAddSanPham(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateSanPham(request, response);
        } else if (uri.contains("sort-gia")) {
            this.sortSanPham(request, response);
        } else if (uri.contains("san-pham-cai")) {
            this.sanPhamCai(request, response);
        } else if (uri.contains("loai")) {
            this.loaiSanPham(request, response);
        } else if (uri.contains("view-hien-thi")) {
            this.viewHienThi(request, response);
        } else {
            this.hienThiSanPham(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addSanPham(request, response);
        } else if (uri.contains("update")) {
            this.updateSanPham(request, response);
        } else {
            this.hienThiSanPham(request, response);
        }
    }

    private void updateSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String loai = request.getParameter("loai");
        String gioiTinh = request.getParameter("gioiTinh");
        String gia = request.getParameter("gia");
        SanPham sp = sanPhamService.updateSanPham(listSanPham, Integer.valueOf(id));

        sp.setId(Integer.valueOf(id));
        sp.setMa(ma);
        sp.setTen(ten);
        if (loai.equalsIgnoreCase("loai 1")) {
            sp.setLoai("loai 1");
        } else if (loai.equalsIgnoreCase("loai 2")) {
            sp.setLoai("loai 2");
        } else if (loai.equalsIgnoreCase("loai 3")) {
            sp.setLoai("loai 3");
        } else if (loai.equalsIgnoreCase("loai 4")) {
            sp.setLoai("loai 4");
        }
        if (Boolean.valueOf(gioiTinh) == true) {
            sp.setGioiTinh(true);
        } else {
            sp.setGioiTinh(false);
        }
        sp.setGia(Integer.valueOf(gia));

        listSanPham.set(sanPhamService.viTriUpdate(listSanPham, sp.getId()), sp);
        response.sendRedirect("/san-pham/hien-thi");
    }

    private void addSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String loai = request.getParameter("loai");
        String gioiTinh = request.getParameter("gioiTinh");
        String gia = request.getParameter("gia");

        if (id.isEmpty() || ma.isEmpty() || ten.isEmpty() || gia.isEmpty()) {
            request.setAttribute("error", "trong");
            this.hienThiSanPham(request, response);
        } else if (Integer.valueOf(gia) < 0) {
            request.setAttribute("error", "phải la so nguyen duong");
            this.hienThiSanPham(request, response);
        } else if (Integer.valueOf(gia) < 150) {
            request.setAttribute("error", "phải lon hơn 150");
            this.hienThiSanPham(request, response);
        } else {
            SanPham sp = SanPham.builder()
                    .id(Integer.valueOf(id))
                    .ma(ma)
                    .ten(ten)
                    .loai(loai)
                    .gioiTinh(Boolean.valueOf(gioiTinh))
                    .gia(Integer.valueOf(gia))
                    .build();

            listSanPham.add(sp);
            request.setAttribute("listSP", listSanPham);
            request.getRequestDispatcher("/lab1_4/trang-chu.jsp").forward(request, response);
        }

    }

    private void searchSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("ten");
        listSanPham = sanPhamService.searchTen(listSanPham, ten);
        request.setAttribute("listSP", listSanPham);
        request.getRequestDispatcher("/lab1_4/trang-chu.jsp").forward(request, response);
    }

    private void detailSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SanPham sp = sanPhamService.detailSanPham(listSanPham, Integer.valueOf(id));
        request.setAttribute("sp", sp);
        request.setAttribute("listSP", listSanPham);
        request.getRequestDispatcher("/lab1_4/trang-chu.jsp").forward(request, response);

    }

    private void deleteSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        sanPhamService.deleteSanPham(listSanPham, Integer.valueOf(id));
        response.sendRedirect("/san-pham/hien-thi");
    }

    private void viewAddSanPham(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdateSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SanPham sp = sanPhamService.updateSanPham(listSanPham, Integer.valueOf(id));
        request.setAttribute("sp", sp);
        request.getRequestDispatcher("/lab1_4/update.jsp").forward(request, response);
    }

    private void sortSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listSanPham = sanPhamService.sortSanPham(listSanPham);
        request.setAttribute("listSP", listSanPham);
        request.getRequestDispatcher("/lab1_4/trang-chu.jsp").forward(request, response);
    }

    private void sanPhamCai(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        listSanPham = sanPhamService.sanPhamCai(listSanPham, false);
        request.setAttribute("listSP", listSanPham);
        request.getRequestDispatcher("/lab1_4/trang-chu.jsp").forward(request, response);
    }

    private void loaiSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listSanPham = sanPhamService.loaiSanPham(listSanPham, "loai 1");
        request.setAttribute("listSP", listSanPham);
        request.getRequestDispatcher("/lab1_4/trang-chu.jsp").forward(request, response);
    }

    private void hienThiSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(listSanPham.isEmpty()){
            listSanPham = sanPhamService.getAll();
        }
        request.setAttribute("listSP", listSanPham);
        request.getRequestDispatcher("/lab1_4/trang-chu.jsp").forward(request, response);
    }

    private void viewHienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//            listSanPham = sanPhamService.getAll();
//
//
//        for(int i = 0 ; i < listSanPham.size(); i++){
//            System.out.println(listSanPham.get(i).getId());
//        }
//        request.setAttribute("listSP", listSanPham);
//        request.getRequestDispatcher("/lab1_4/trang-chu.jsp").forward(request, response);
    }

}

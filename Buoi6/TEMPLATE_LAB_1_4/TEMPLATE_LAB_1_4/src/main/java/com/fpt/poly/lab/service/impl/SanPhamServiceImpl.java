package com.fpt.poly.lab.service.impl;

import com.fpt.poly.lab.entity.SanPham;
import com.fpt.poly.lab.service.SanPhamService;

import java.util.ArrayList;
import java.util.List;

public class SanPhamServiceImpl implements SanPhamService {
    @Override
    public List<SanPham> getAll() {
        List<SanPham> listSanPham = new ArrayList<>();
        listSanPham.add(new SanPham(1, "a", "Kẹo", "loai 1", true, 20));
        listSanPham.add(new SanPham(2, "b", "Kem", "loai 2", false, 10));
        listSanPham.add(new SanPham(3, "c", "Bim Bim", "loai 3", true, 30));
        listSanPham.add(new SanPham(4, "d", "Sữa Chua", "loai 4", false, 9));
        listSanPham.add(new SanPham(5, "e", "Dâu", "loai 1", true, 2));
        return listSanPham;
    }

    @Override
    public void deleteSanPham(List<SanPham> list, int id) {
        int viTri = viTriCanTim(list, id);
        list.remove(viTri);
    }

    @Override
    public SanPham detailSanPham(List<SanPham> list, int id) {
        int viTri = viTriCanTim(list, id);
        return list.get(viTri);
    }

    @Override
    public int viTriUpdate(List<SanPham> list, int id) {
        int viTri = viTriCanTim(list, id);
        return viTri;
    }

    @Override
    public SanPham updateSanPham(List<SanPham> list, int id) {
        int viTri = viTriCanTim(list, id);
        return list.get(viTri);
    }

    @Override
    public List<SanPham> sortSanPham(List<SanPham> list) {
        list.sort((o1, o2) -> o1.getGia() - o2.getGia());
        return list;
    }

    @Override
    public List<SanPham> searchTen(List<SanPham> list, String ten) {
        List<SanPham> listSanPham = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTen().equalsIgnoreCase(ten)) {
                listSanPham.add(list.get(i));
            }
        }
        return listSanPham;
    }

    @Override
    public List<SanPham> sanPhamCai(List<SanPham> list, boolean gioiTinh) {
        List<SanPham> listSanPham = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isGioiTinh() == gioiTinh) {
                listSanPham.add(list.get(i));
            }
        }
        return listSanPham;
    }

    @Override
    public List<SanPham> loaiSanPham(List<SanPham> list, String loai) {
        List<SanPham> listSanPham = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLoai().equalsIgnoreCase(loai)) {
                listSanPham.add(list.get(i));
            }
        }
        return listSanPham;
    }

    private int viTriCanTim(List<SanPham> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}

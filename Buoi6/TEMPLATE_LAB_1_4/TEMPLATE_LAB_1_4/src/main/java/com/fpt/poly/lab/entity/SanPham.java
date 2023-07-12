package com.fpt.poly.lab.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SanPham {
    private int id;
    private String ma;
    private String ten;
    private String loai;
    private boolean gioiTinh;
    private int gia;
}

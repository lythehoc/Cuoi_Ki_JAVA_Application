package model;

import java.io.Serializable;
import java.sql.Date;
public class NhanVien implements Serializable {
    private int ma_nhan_vien;
    private String ho_ten;
    private String so_dien_thoai;
    private String dia_chi;
    private Date ngay_sinh;
    private boolean Gioi_tinh;
    private boolean Tinh_trang;

    public void setMa_nhan_vien(int ma_nhan_vien) {
        this.ma_nhan_vien = ma_nhan_vien;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public void setSo_dien_thoai(String so_dien_thoai) {
        this.so_dien_thoai = so_dien_thoai;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public void setNgay_sinh(Date ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public void setGioi_tinh(boolean gioi_tinh) {
        this.Gioi_tinh = gioi_tinh;
    }

    public void setTinh_trang(boolean tinh_trang) {
        this.Tinh_trang = tinh_trang;
    }

    public int getMa_nhan_vien() {
        return ma_nhan_vien;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public String getSo_dien_thoai() {
        return so_dien_thoai;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public Date getNgay_sinh() {
        return ngay_sinh;
    }

    public boolean isGioi_tinh() {
        return Gioi_tinh;
    }

    public boolean isTinh_trang() {
        return Tinh_trang;
    }
}
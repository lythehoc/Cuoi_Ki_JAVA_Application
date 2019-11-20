package model;

import java.io.Serializable;

public class PhongBan implements Serializable {
    private int ma_phong_ban;
    private String ten_phong_ban;
    private int so_nhan_vien;
    private int so_du_an;
    private String mo_ta;

    public void setMa_phong_ban(int ma_phong_ban) {
        this.ma_phong_ban = ma_phong_ban;
    }

    public void setTen_phong_ban(String ten_phong_ban) {
        this.ten_phong_ban = ten_phong_ban;
    }

    public void setSo_nhan_vien(int so_nhan_vien) {
        this.so_nhan_vien = so_nhan_vien;
    }

    public void setSo_du_an(int so_du_an) {
        this.so_du_an = so_du_an;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public int getMa_phong_ban() {
        return ma_phong_ban;
    }

    public String getTen_phong_ban() {
        return ten_phong_ban;
    }

    public int getSo_nhan_vien() {
        return so_nhan_vien;
    }

    public int getSo_du_an() {
        return so_du_an;
    }

    public String getMo_ta() {
        return mo_ta;
    }
}
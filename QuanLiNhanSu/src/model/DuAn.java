package model;

import java.io.Serializable;
import java.sql.Date;
 
public class DuAn implements Serializable {
    
    private int ma_du_an;
    private String ten_du_an;
    private String mo_ta;
    private Date ngay_bat_dau;
    private Date ngay_ket_thuc;
    private boolean tinh_trang;

    public void setMa_du_an(int ma_du_an) {
        this.ma_du_an = ma_du_an;
    }

    public void setTen_du_an(String ten_du_an) {
        this.ten_du_an = ten_du_an;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public void setNgay_bat_dau(Date ngay_bat_dau) {
        this.ngay_bat_dau = ngay_bat_dau;
    }

    public void setNgay_ket_thuc(Date ngay_ket_thuc) {
        this.ngay_ket_thuc = ngay_ket_thuc;
    }

    public void setTinh_trang(boolean tinh_trang) {
        this.tinh_trang = tinh_trang;
    }

    public int getMa_du_an() {
        return ma_du_an;
    }

    public String getTen_du_an() {
        return ten_du_an;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public Date getNgay_bat_dau() {
        return ngay_bat_dau;
    }

    public Date getNgay_ket_thuc() {
        return ngay_ket_thuc;
    }

    public boolean isTinh_trang() {
        return tinh_trang;
    }
}
package model;

import java.io.Serializable;
import java.sql.Date;

public class PhongBan implements Serializable {
    private int ma_phong_ban;
    private DuAn duAn;
    private NhanVien nhanVien;
    private Date ngay_dang_ky;
    private boolean tinh_trang;

    public void setMa_phong_ban(int ma_phong_ban) {
        this.ma_phong_ban = ma_phong_ban;
    }

    public void setDuAn(DuAn duAn) {
        this.duAn = duAn;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public void setNgay_dang_ky(Date ngay_dang_ky) {
        this.ngay_dang_ky = ngay_dang_ky;
    }

    public void setTinh_trang(boolean tinh_trang) {
        this.tinh_trang = tinh_trang;
    }

    public int getMa_phong_ban() {
        return ma_phong_ban;
    }

    public DuAn getDuAn() {
        return duAn;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public Date getNgay_dang_ky() {
        return ngay_dang_ky;
    }

    public boolean isTinh_trang() {
        return tinh_trang;
    }
}

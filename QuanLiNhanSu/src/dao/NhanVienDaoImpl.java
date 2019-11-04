
package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;


public class NhanVienDaoImpl implements NhanVienDao{

    @Override
    public List<NhanVien> getList() {
         try{
             List<NhanVien> list;
             try (Connection cons = DBConnect.getConnection()) {
                 String sql = "SELECT * FROM nhan_vien";
                 list = new ArrayList<>();
                 Statement ps = cons.createStatement();
                 ResultSet rs = ps.executeQuery(sql);
                 while(rs.next()){
                     NhanVien nhanVien = new NhanVien();
                     nhanVien.setMa_nhan_vien(rs.getInt("ma_nhan_vien"));
                     nhanVien.setHo_ten(rs.getString("ho_ten"));
                     nhanVien.setNgay_sinh(rs.getDate("ngay_sinh"));
                     nhanVien.setGioi_tinh(rs.getBoolean("gioi_tinh"));
                     nhanVien.setSo_dien_thoai(rs.getString("so_dien_thoai"));
                     nhanVien.setDia_chi(rs.getString("dia_chi"));
                     nhanVien.setTinh_trang(rs.getBoolean("tinh_trang"));
                     
                     list.add(nhanVien);
                 }        ps.close();
                 rs.close();
             }
        return list;
    }
    catch  (SQLException ex){
    ex.printStackTrace();
}
    return null;
    
}
    public static void main(String[] args) {
        NhanVienDao nhanVienDao = new NhanVienDaoImpl();
        System.out.println(nhanVienDao.getList());
    }
}
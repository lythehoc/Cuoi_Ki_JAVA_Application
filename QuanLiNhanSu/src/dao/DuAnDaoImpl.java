package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.DuAn;
import model.NhanVien;

public class DuAnDaoImpl implements DuAnDao{
    @Override
    public List<DuAn> getList() {
         try{
             List<DuAn> list;
             try (Connection cons = DBConnect.getConnection()) {
                 String sql = "SELECT * FROM du_an";
                 list = new ArrayList<>();
                 Statement ps = cons.createStatement();
                 ResultSet rs = ps.executeQuery(sql);
                 while(rs.next()){
                     DuAn duAn = new DuAn();
                     duAn.setMa_nhan_vien(rs.getInt("ma_nhan_vien"));
                     duAn.setHo_ten(rs.getString("ho_ten"));
                     duAn.setNgay_sinh(rs.getDate("ngay_sinh"));
                     duAn.setGioi_tinh(rs.getBoolean("gioi_tinh"));
                     duAn.setSo_dien_thoai(rs.getString("so_dien_thoai"));
                     duAn.setDia_chi(rs.getString("dia_chi"));
                     list.add(nhanVien);
                }        
                ps.close();
                rs.close();
             }
            return list;
        }
    catch  (SQLException e){
        e.printStackTrace();
    }
    return null;
    
}
    @Override
    public int createOrUpdate(NhanVien nhanVien) {
            try{
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO nhan_vien (ma_nhan_vien, ho_ten, ngay_sinh, gioi_tinh, so_dien_thoai, dia_chi, tinh_trang) VALUES (?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE ho_ten = VALUES(ho_ten), ngay_sinh = VALUES(ngay_sinh), gioi_tinh = VALUES(gioi_tinh), so_dien_thoai = VALUES(so_dien_thoai), dia_chi = VALUES(dia_chi), tinh_trang = VALUES(tinh_trang);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, nhanVien.getMa_nhan_vien());
            ps.setString(2, nhanVien.getHo_ten());
            ps.setDate(3, new Date(nhanVien.getNgay_sinh().getTime()));
            ps.setBoolean(4, nhanVien.isGioi_tinh());
            ps.setString(5, nhanVien.getSo_dien_thoai());
            ps.setString(6, nhanVien.getDia_chi());
            ps.setBoolean(7, nhanVien.isTinh_trang());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            cons.close();
            return generatedKey;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    public static void main(String[] args) {
        NhanVienDao nhanVienDao = new NhanVienDaoImpl();
        System.out.println(nhanVienDao.getList());
    }
}
package Controller;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.NhanVien;

public class NhanVienController {
    private JButton btnSubmit;
    private JTextField jtfMaNhanVien;
    private JTextField jtfHoTen;
    private JDateChooser jdcNgaySinh;
    private JRadioButton jrdNam;
    private JRadioButton jrdNu;
     private JTextField jtfSoDienThoai;
    private JTextArea jtaDiaChi;
     private JCheckBox jcbTinhTrang;


    public NhanVienController(JButton btnSubmit, JTextField jtfMaNhanVien, JTextField jtfHoTen,JDateChooser jdcNgaySinh, JRadioButton idrNam, JRadioButton idrNu, JTextField jtfSoDienThoai, JTextArea jtaDiaChi, JCheckBox jcbTinhTrang) {
        this.btnSubmit = btnSubmit;
        this.jtfMaNhanVien = jtfMaNhanVien;
        this.jtfHoTen = jtfHoTen;
        this.jdcNgaySinh = jdcNgaySinh;
        this.jrdNam = jrdNam;
        this.jrdNu = jrdNu;
        this.jtfSoDienThoai = jtfSoDienThoai;
        this.jtaDiaChi = jtaDiaChi;
        this.jcbTinhTrang = jcbTinhTrang;
    }
   
    public void setView(NhanVien nhanVien){
        jtfMaNhanVien.setText("#" + nhanVien.getMa_nhan_vien());
        jtfHoTen.setText(nhanVien.getHo_ten());
//         if (nhanVien.isGioi_tinh()) {
//            jrdNam.setSelected(true);
//        } else {
//            jrdNu.setSelected(true);
//        }
        
        jtfSoDienThoai.setText(nhanVien.getSo_dien_thoai());
        jtaDiaChi.setText(nhanVien.getDia_chi());
        jcbTinhTrang.setSelected(nhanVien.isTinh_trang());

        //setEvent();
        
    }
}

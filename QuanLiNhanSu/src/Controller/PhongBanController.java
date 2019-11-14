package Controller;

import Service.NhanVienService;
import Service.NhanVienServiceImpl;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.NhanVien;

public class PhongBanController {
     private JButton btnSubmit;
    private JTextField jtfMaNhanVien;
    private JTextField jtfHoTen;
    private JDateChooser jdcNgaySinh;
    private JRadioButton jrdNam;
    private JRadioButton jrdNu;
    private JTextField jtfSoDienThoai;
    private JTextArea jtaDiaChi;
    private JCheckBox jcbTinhTrang;
    private JLabel jlbMsg;
    private NhanVien nhanVien = null;
    private NhanVienService nhanVienService = null;

    public NhanVienController(JButton btnSubmit, JTextField jtfMaNhanVien, 
            JTextField jtfHoTen,JDateChooser jdcNgaySinh, JRadioButton jrdNam, 
            JRadioButton jrdNu, JTextField jtfSoDienThoai, JTextArea jtaDiaChi, JCheckBox jcbTinhTrang, JLabel jlbMsg){
        this.btnSubmit = btnSubmit;
        this.jtfMaNhanVien = jtfMaNhanVien;
        this.jtfHoTen = jtfHoTen;
        this.jdcNgaySinh = jdcNgaySinh;
        this.jrdNam = jrdNam;
        this.jrdNu = jrdNu;
        this.jtfSoDienThoai = jtfSoDienThoai;
        this.jtaDiaChi = jtaDiaChi;
        this.jcbTinhTrang = jcbTinhTrang;
        this.jlbMsg = jlbMsg;
        this.nhanVienService = new NhanVienServiceImpl();
    }
   
    public void setView(NhanVien nhanVien){
        this.nhanVien = nhanVien;
        jtfMaNhanVien.setText("#" + nhanVien.getMa_nhan_vien());
        jtfHoTen.setText(nhanVien.getHo_ten());
        jdcNgaySinh.setDate(nhanVien.getNgay_sinh());
        if(nhanVien.isGioi_tinh()){
            jrdNam.setSelected(true);
            jrdNam.setSelected(false);
        }else{
            jrdNu.setSelected(false);
            jrdNu.setSelected(true);
        }
        jtfSoDienThoai.setText(nhanVien.getSo_dien_thoai());
        jtaDiaChi.setText(nhanVien.getDia_chi());
        jcbTinhTrang.setSelected(nhanVien.isTinh_trang());
        setEvent();
    }
    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter(){
            
            @Override
                public void mouseClicked(MouseEvent e){
                    try{
                        if (jtfMaNhanVien.getText().length() == 0){
                            jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
                        }
                    else {
                        nhanVien.setHo_ten(jtfHoTen.getText().trim());
                        nhanVien.setNgay_sinh(covertDateToDateSql(jdcNgaySinh.getDate()));
                        nhanVien.setSo_dien_thoai(jtfSoDienThoai.getText());
                        nhanVien.setDia_chi(jtaDiaChi.getText());
                        nhanVien.setGioi_tinh(jrdNam.isSelected());
                        nhanVien.setTinh_trang(jcbTinhTrang.isSelected());
                        if (showDialog()) {
                            int lastId = nhanVienService.createOrUpdate(nhanVien);
                            if (lastId != 0) {
                                nhanVien.setMa_nhan_vien(lastId);
                                jtfMaNhanVien.setText("#" + nhanVien.getMa_nhan_vien());
                                jlbMsg.setText("Xử lý cập nhật dữ liệu thành công!");
                            } else {
                                jlbMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
                            }
                        }
                    }
                } catch (Exception ex) {
                    jlbMsg.setText(ex.toString());
                }
            }
 
                @Override
                public void mouseEntered(MouseEvent me) {
                    btnSubmit.setBackground(new Color(0, 200, 83));
                }

                @Override
                public void mouseExited(MouseEvent me) {
                     btnSubmit.setBackground(new Color(100, 221, 23));
                }
                 private boolean showDialog() {
                 int dialogResult = JOptionPane.showConfirmDialog(null,
                 "Bạn muốn cập nhật dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
                    return dialogResult == JOptionPane.YES_OPTION;
                }

                private Date covertDateToDateSql(java.util.Date date) {
                  return new java.sql.Date(date.getTime());
                }
            });  
    }
}

package view;

import dao.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.NhanVien;

public class NhanVienJPanel extends javax.swing.JPanel {
    private JPanel jpnChinh;
    private JPanel jpnDetail;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JLabel jLabel2;
    private JLabel jLabel4;
    private JLabel jLabel3;
    private JLabel jLabel5;
    private JTextField jtfNgaySinh;
    private JRadioButton jrdNam;
    private JRadioButton jrdNu;
    private JCheckBox jcbTinhTrang;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JTextField jtfSoDienThoai;
    private JScrollPane jScrollPane2;
    private JTextArea jtaDiaChi;
    private JButton btnReset;
    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JScrollPane jScrollPane1;
    private JTable jtbNhanVien;
    private JTextField jtfHoTen;

    public NhanVienJPanel() {
        initComponents();
        showNhanVien();
    }
    private List<NhanVien> getAllNV() {
        List<NhanVien> ListAllNV
                = new ArrayList<NhanVien>();
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM nhan_vien ";
        Statement stmt = null;
        ResultSet rsSet = null;
        try {
            stmt = cons.createStatement();
            rsSet = stmt.executeQuery(sql);
            NhanVien nhanvien = null;
            while (rsSet.next()) {
                nhanvien = new NhanVien();
                nhanvien.setMa_nhan_vien(rsSet.getInt("ma_nhan_vien"));
                nhanvien.setHo_ten(rsSet.getString("ho_ten"));
                nhanvien.setNgay_sinh(rsSet.getDate("ngay_sinh"));
                nhanvien.setGioi_tinh(rsSet.getBoolean("gioi_tinh"));
                nhanvien.setSo_dien_thoai(rsSet.getString("so_dien_thoai"));
                nhanvien.setDia_chi(rsSet.getString("dia_chi"));
                nhanvien.setTinh_trang(rsSet.getBoolean("tinh_trang"));
                ListAllNV.add(nhanvien);
            }
            cons.close();
            rsSet.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ListAllNV;
    }
    private void showNhanVien() {
        List<NhanVien> listNV = getAllNV();
        DefaultTableModel model
                = (DefaultTableModel) jtbNhanVien.getModel();
        Object[] row = new Object[7];
        for (int i = 0; i < listNV.size(); i++) {
            row[0] = listNV.get(i).getMa_nhan_vien();
            row[1] = listNV.get(i).getHo_ten();
            row[2] = listNV.get(i).getNgay_sinh();
            row[3] = listNV.get(i).isGioi_tinh() == true ? "Nam" : "Nữ";
            row[4] = listNV.get(i).getSo_dien_thoai();
            row[5] = listNV.get(i).getDia_chi();
            row[6] = listNV.get(i).isTinh_trang()== true ? "Còn làm" : "Tạm nghỉ";
            model.addRow(row);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnChinh = new javax.swing.JPanel();
        jpnDetail = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfNgaySinh = new javax.swing.JTextField();
        jrdNam = new javax.swing.JRadioButton();
        jrdNu = new javax.swing.JRadioButton();
        jcbTinhTrang = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfSoDienThoai = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaDiaChi = new javax.swing.JTextArea();
        jtfHoTen = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbNhanVien = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(500, 700));

        jpnChinh.setPreferredSize(new java.awt.Dimension(500, 200));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Họ tên");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Ngày sinh");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Giới Tính");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Tình trạng");

        jrdNam.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jrdNam.setText("Nam");

        jrdNu.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jrdNu.setText("Nữ");

        jcbTinhTrang.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcbTinhTrang.setText("Kích Hoạt");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Số điện thoại");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Địa chỉ");

        jtaDiaChi.setColumns(20);
        jtaDiaChi.setRows(5);
        jScrollPane2.setViewportView(jtaDiaChi);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jrdNam)
                                .addGap(54, 54, 54)
                                .addComponent(jrdNu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfSoDienThoai)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jcbTinhTrang)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtfSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jtfHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrdNam, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jrdNu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbTinhTrang)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel7))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(204, 0, 0));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_delete.png"))); // NOI18N
        btnReset.setText("Đặt lại");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(204, 0, 0));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_delete.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(51, 0, 255));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addemp.png"))); // NOI18N
        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(204, 0, 0));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_delete.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete)
                .addGap(117, 117, 117)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(btnReset)
                .addGap(87, 87, 87)
                .addComponent(btnAdd)
                .addGap(20, 20, 20))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jpnDetailLayout = new javax.swing.GroupLayout(jpnDetail);
        jpnDetail.setLayout(jpnDetailLayout);
        jpnDetailLayout.setHorizontalGroup(
            jpnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnDetailLayout.setVerticalGroup(
            jpnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jtbNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Họ và tên", "Ngày sinh", "Giới tính", "Số điện thoại", "Địa chỉ", "Trình trạng"
            }
        ));
        jtbNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbNhanVien);
        if (jtbNhanVien.getColumnModel().getColumnCount() > 0) {
            jtbNhanVien.getColumnModel().getColumn(0).setResizable(false);
            jtbNhanVien.getColumnModel().getColumn(0).setPreferredWidth(15);
            jtbNhanVien.getColumnModel().getColumn(3).setPreferredWidth(40);
        }

        javax.swing.GroupLayout jpnChinhLayout = new javax.swing.GroupLayout(jpnChinh);
        jpnChinh.setLayout(jpnChinhLayout);
        jpnChinhLayout.setHorizontalGroup(
            jpnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnChinhLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpnChinhLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 5, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpnChinhLayout.setVerticalGroup(
            jpnChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnChinhLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnChinh, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnChinh, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Connection cons = DBConnect.getConnection();
        String ID;
        int rowIndex = jtbNhanVien.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jtbNhanVien.getModel();
        ID = model.getValueAt(rowIndex, 0).toString();
        String sql = " UPDATE nhan_vien SET ho_ten=?, ngay_sinh=?, gioi_tinh=?, so_dien_thoai=?, dia_chi=?, tinh_trang=? WHERE ma_nhan_vien=" + ID;
        PreparedStatement preStmt = null;
        String Ten = jtfHoTen.getText();
        String NgaySinh = jtfNgaySinh.getText();
        Boolean GioiTinh ;
        if (jrdNam.isSelected()) {
            GioiTinh = true;
        } else {
            GioiTinh = false;
        }
        String SoDienThoai = jtfSoDienThoai.getText();
        String DiaChi = jtaDiaChi.getText();
        Boolean TinhTrang ;
        if (jcbTinhTrang.isSelected()) {
            TinhTrang = true;
        } else {
            TinhTrang = false;
        }
        int row = 0;
        try {
            preStmt = cons.prepareStatement(sql);
            preStmt.setString(1, Ten);
            preStmt.setString(2, NgaySinh);
            preStmt.setBoolean(3, GioiTinh);
            preStmt.setString(4, SoDienThoai);
            preStmt.setString(5, DiaChi);
            preStmt.setBoolean(6, TinhTrang);
            row = preStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
            model.setRowCount(0);
            showNhanVien();
            System.out.println("Row inserted" + row);
            cons.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }                                 
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jtbNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbNhanVienMouseClicked
        int rowIndex = jtbNhanVien.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jtbNhanVien.getModel();
        jtfHoTen.setText(model.getValueAt(rowIndex, 1).toString());
        jtfNgaySinh.setText(model.getValueAt(rowIndex, 2).toString());
        String GioiTinh = model.getValueAt(rowIndex, 3).toString();
        if (GioiTinh.equals("Nam")) {
            jrdNam.setSelected(true);
            jrdNu.setSelected(false);
        } else {
            jrdNam.setSelected(false);
            jrdNu.setSelected(true);
        }
        jtfSoDienThoai.setText(model.getValueAt(rowIndex, 4).toString());
        jtaDiaChi.setText(model.getValueAt(rowIndex, 5).toString());
        String Tinhtrang = model.getValueAt(rowIndex, 6).toString();
        if (Tinhtrang.equals("Còn làm")) {
            jcbTinhTrang.setSelected(true);
        } else {
            jcbTinhTrang.setSelected(false);
        }          
    }//GEN-LAST:event_jtbNhanVienMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int opt = JOptionPane.showConfirmDialog(null, "Ban co that su muon xoa khong?",  "Xóa", JOptionPane.YES_NO_OPTION);
        if (opt ==0){ 
        Connection cons = DBConnect.getConnection();
        String Id;
        int rowIndex = jtbNhanVien.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jtbNhanVien.getModel();
        Id = model.getValueAt(rowIndex, 0).toString();
        String sql = " DELETE nhan_vien WHERE ma_nhan_vien =" +Id;
        PreparedStatement preStmt = null;
        int row = 0;
        try {
            preStmt = cons.prepareStatement(sql);
            row = preStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa thành công!");
            model.setRowCount(0);
            showNhanVien();
            cons.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } }                                             
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Connection cons = DBConnect.getConnection();
        String sql = "INSERT INTO nhan_vien " + " VALUES (?, ?, ?, ?, ?, ? )";
        PreparedStatement preStmt = null;
        String Ten = jtfHoTen.getText();
        String NgaySinh = jtfNgaySinh.getText();       
        Boolean GioiTinh;
        if (jrdNam.isSelected()) {
            GioiTinh = true;
        } else {
            GioiTinh = false;
        }
        String SoDienThoai = jtfSoDienThoai.getText();
        String DiaChi = jtaDiaChi.getText();
        Boolean Tinhtrang;
        if (jcbTinhTrang.isSelected()) {
            Tinhtrang = true;
        } else {
            Tinhtrang = false;
        }
        int row = 0;
        try {
            preStmt = cons.prepareStatement(sql);
            preStmt.setString(1, Ten);
            preStmt.setString(2, NgaySinh);
            preStmt.setBoolean(3, GioiTinh);
            preStmt.setString(4, SoDienThoai);
            preStmt.setString(5, DiaChi);
            preStmt.setBoolean(6, Tinhtrang);
            row = preStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm mới thành công!");
            System.out.println("Row inserted" + row);
            DefaultTableModel model = (DefaultTableModel) jtbNhanVien.getModel();
            model.setRowCount(0);
            showNhanVien();
            cons.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }                                      

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        jtfHoTen.setText("");
        jtfNgaySinh.setText("");
        jrdNam.setSelected(true);
        jtfSoDienThoai.setText("");
        jtaDiaChi.setText("");
        jcbTinhTrang.setSelected(true);
    }//GEN-LAST:event_btnResetActionPerformed
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox jcbTinhTrang;
    private javax.swing.JPanel jpnChinh;
    private javax.swing.JPanel jpnDetail;
    private javax.swing.JRadioButton jrdNam;
    private javax.swing.JRadioButton jrdNu;
    private javax.swing.JTextArea jtaDiaChi;
    private javax.swing.JTable jtbNhanVien;
    private javax.swing.JTextField jtfHoTen;
    private javax.swing.JTextField jtfNgaySinh;
    private javax.swing.JTextField jtfSoDienThoai;
    // End of variables declaration//GEN-END:variables


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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.PhongBan;

public class PhongBanJPanel extends javax.swing.JPanel {

    public PhongBanJPanel() {
        initComponents();
        showPhongBan();
    }
    private List<PhongBan> getAllPB() {
        List<PhongBan> ListAllPB
                = new ArrayList<PhongBan>();
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM phong_ban ";
        Statement stmt = null;
        ResultSet rsSet = null;
        try {
            stmt = cons.createStatement();
            rsSet = stmt.executeQuery(sql);
            PhongBan phongBan = null;
            while (rsSet.next()) {
                phongBan = new PhongBan();
                phongBan.setMa_phong_ban(rsSet.getInt("ma_phong_ban"));
                phongBan.setTen_phong_ban(rsSet.getString("ten_phong_ban"));
                phongBan.setSo_nhan_vien(rsSet.getInt("so_nhan_vien"));
                phongBan.setSo_du_an(rsSet.getInt("so_du_an"));
                phongBan.setMo_ta(rsSet.getString("mo_ta"));              
                ListAllPB.add(phongBan);
            }
            cons.close();
            rsSet.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ListAllPB;
    }
    private void showPhongBan() {
        List<PhongBan> listPB = getAllPB();
        DefaultTableModel model
                = (DefaultTableModel) jtbPhongBan.getModel();
        Object[] row = new Object[5];
        for (int i = 0; i < listPB.size(); i++) {
            row[0] = listPB.get(i).getMa_phong_ban();
            row[1] = listPB.get(i).getTen_phong_ban();
            row[2] = listPB.get(i).getSo_nhan_vien();
            row[3] = listPB.get(i).getSo_du_an();
            row[4] = listPB.get(i).getMo_ta();
            model.addRow(row);
        }
 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbPhongBan = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfTenPhongBan = new javax.swing.JTextField();
        jtfSoNhanVien = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaMoTa = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jtfSoDuAn = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(500, 700));

        jpnRoot.setPreferredSize(new java.awt.Dimension(500, 200));

        jtbPhongBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên phòng ban", "Số nhân viên", "Số dự án", "Mô tả"
            }
        ));
        jtbPhongBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbPhongBanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbPhongBan);

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAdd.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(0, 153, 51));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_add.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(0, 153, 51));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_add.png"))); // NOI18N
        btnReset.setText("Đặt lại");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 153, 51));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_add.png"))); // NOI18N
        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin phòng ban", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Tên phòng ban");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Số lượng nhân viên");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Mô tả");

        jtfTenPhongBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTenPhongBanActionPerformed(evt);
            }
        });

        jtaMoTa.setColumns(20);
        jtaMoTa.setRows(5);
        jScrollPane2.setViewportView(jtaMoTa);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Số lượng dự án");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jtfSoDuAn, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jtfSoNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                        .addComponent(jtfTenPhongBan, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfTenPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfSoNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfSoDuAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(204, 0, 0));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_delete.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnRoot, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnRoot, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtfTenPhongBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTenPhongBanActionPerformed
        
    }//GEN-LAST:event_jtfTenPhongBanActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int opt = JOptionPane.showConfirmDialog(null, "Bạn có thật sự muốn xóa không?",  "Xóa", JOptionPane.YES_NO_OPTION);
        if (opt ==0){ 
        Connection cons = DBConnect.getConnection();
        String Id;
        int rowIndex = jtbPhongBan.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jtbPhongBan.getModel();
        Id = model.getValueAt(rowIndex, 0).toString();
        String sql = " DELETE phong_ban WHERE ma_phong_ban=" +Id;
        PreparedStatement preStmt = null;
        int row = 0;
        try {
            preStmt = cons.prepareStatement(sql);
            row = preStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa thành công!");
            model.setRowCount(0);
            showPhongBan();
            cons.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } }            
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Connection cons = DBConnect.getConnection();
        String ID;
        int rowIndex = jtbPhongBan.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jtbPhongBan.getModel();
        ID = model.getValueAt(rowIndex, 0).toString();
        String sql = " UPDATE phong_ban SET ten_phong_ban=?, so_nhan_vien=?, so_du_an=?, mo_ta=? WHERE ma_phong_ban=" + ID;
        PreparedStatement preStmt = null;
        String Ten = jtfTenPhongBan.getText();   
        String SoNhanVien = jtfSoNhanVien.getText();
        String SoDuAn = jtfSoDuAn.getText();
        String MoTa = jtaMoTa.getText();
        int row = 0;
        try {
            preStmt = cons.prepareStatement(sql);
            preStmt.setString(1, Ten);
            preStmt.setString(2, SoNhanVien);
            preStmt.setString(3, SoDuAn);
            preStmt.setString(4, MoTa);
            row = preStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
            model.setRowCount(0);
            showPhongBan();
            System.out.println("Row inserted" + row);
            cons.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        jtfTenPhongBan.setText("");
        jtaMoTa.setText("");
        jtfSoDuAn.setText("");
        jtfSoNhanVien.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       Connection cons = DBConnect.getConnection();
        String sql = "INSERT INTO phong_ban " + " VALUES (?, ?, ?, ?)";
        PreparedStatement preStmt = null;
        String Ten = jtfTenPhongBan.getText();   
        String SoNhanVien = jtfSoNhanVien.getText();
        String SoDuAn = jtfSoDuAn.getText();
        String MoTa = jtaMoTa.getText();
        int row = 0;
        try {
            preStmt = cons.prepareStatement(sql);
            preStmt.setString(1, Ten);
            preStmt.setString(2, SoNhanVien);
            preStmt.setString(3, SoDuAn);
            preStmt.setString(4, MoTa);
            row = preStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm mới thành công!");
            System.out.println("Row inserted" + row);
            DefaultTableModel model = (DefaultTableModel) jtbPhongBan.getModel();
            model.setRowCount(0);
            showPhongBan();
            cons.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }                          
    }//GEN-LAST:event_btnAddActionPerformed

    private void jtbPhongBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbPhongBanMouseClicked
        int rowIndex = jtbPhongBan.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jtbPhongBan.getModel();
        jtfTenPhongBan.setText(model.getValueAt(rowIndex, 1).toString());
        jtfSoNhanVien.setText(model.getValueAt(rowIndex, 2).toString());
        jtfSoDuAn.setText(model.getValueAt(rowIndex, 3).toString());
        jtaMoTa.setText(model.getValueAt(rowIndex, 4).toString());
    }//GEN-LAST:event_jtbPhongBanMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JTextArea jtaMoTa;
    private javax.swing.JTable jtbPhongBan;
    private javax.swing.JTextField jtfSoDuAn;
    private javax.swing.JTextField jtfSoNhanVien;
    private javax.swing.JTextField jtfTenPhongBan;
    // End of variables declaration//GEN-END:variables
}

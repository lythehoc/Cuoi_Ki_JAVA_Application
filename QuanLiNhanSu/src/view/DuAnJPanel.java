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
import model.DuAn;

public class DuAnJPanel extends javax.swing.JPanel {

    public DuAnJPanel() {
        initComponents();
        showDuAn();
    }
    private List<DuAn> getAllDA() {
        List<DuAn> ListAllDA
                = new ArrayList<DuAn>();
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM du_an ";
        Statement stmt = null;
        ResultSet rsSet = null;
        try {
            stmt = cons.createStatement();
            rsSet = stmt.executeQuery(sql);
            DuAn duan = null;
            while (rsSet.next()) {
                duan = new DuAn();
                duan.setMa_du_an(rsSet.getInt("ma_du_an"));
                duan.setTen_du_an(rsSet.getString("ten_du_an"));
                duan.setMo_ta(rsSet.getString("mo_ta"));
                duan.setNgay_bat_dau(rsSet.getDate("ngay_bat_dau"));
                duan.setNgay_ket_thuc(rsSet.getDate("ngay_ket_thuc"));              
                ListAllDA.add(duan);
            }
            cons.close();
            rsSet.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ListAllDA;
    }
    private void showDuAn() {
        List<DuAn> listDA = getAllDA();
        DefaultTableModel model
                = (DefaultTableModel) jtbDuAn.getModel();
        Object[] row = new Object[5];
        for (int i = 0; i < listDA.size(); i++) {
            row[0] = listDA.get(i).getMa_du_an();
            row[1] = listDA.get(i).getTen_du_an();
            row[2] = listDA.get(i).getMo_ta();
            row[3] = listDA.get(i).getNgay_bat_dau();
            row[4] = listDA.get(i).getNgay_ket_thuc();
            model.addRow(row);
        }
 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jpnView = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbDuAn = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfTenDuAn = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaMoTa = new javax.swing.JTextArea();
        jtfNgayBatDau = new javax.swing.JTextField();
        jtfNgayKetThuc = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(500, 700));

        jpnRoot.setPreferredSize(new java.awt.Dimension(500, 200));

        jtbDuAn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên dự án", "Mô Tả", "Ngày bắt đầu", "Ngày kết thúc"
            }
        ));
        jtbDuAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbDuAnMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbDuAn);

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE))
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin dự án", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Tên dự án");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Mô tả");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Ngày bắt đầu");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Ngày kết thúc");

        jtaMoTa.setColumns(20);
        jtaMoTa.setRows(5);
        jScrollPane2.setViewportView(jtaMoTa);

        jtfNgayBatDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNgayBatDauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jtfNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jtfNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfTenDuAn, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(226, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfTenDuAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
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

        btnReset.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 153, 0));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.png"))); // NOI18N
        btnReset.setText("Đặt lại");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 153, 0));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 153, 0));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.png"))); // NOI18N
        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnRoot, javax.swing.GroupLayout.PREFERRED_SIZE, 888, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnRoot, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtfNgayBatDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNgayBatDauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNgayBatDauActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
         int opt = JOptionPane.showConfirmDialog(null, "Bạn có thật sự muốn xóa không?",  "Xóa", JOptionPane.YES_NO_OPTION);
        if (opt ==0){ 
        Connection cons = DBConnect.getConnection();
        String Id;
        int rowIndex = jtbDuAn.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jtbDuAn.getModel();
        Id = model.getValueAt(rowIndex, 0).toString();
        String sql = " DELETE du_an WHERE ma_du_an=" +Id;
        PreparedStatement preStmt = null;
        int row = 0;
        try {
            preStmt = cons.prepareStatement(sql);
            row = preStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa thành công!");
            model.setRowCount(0);
            showDuAn();
            cons.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } }                                          
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Connection cons = DBConnect.getConnection();
        String ID;
        int rowIndex = jtbDuAn.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jtbDuAn.getModel();
        ID = model.getValueAt(rowIndex, 0).toString();
        String sql = " UPDATE du_an SET ten_du_an=?, mo_ta=?, ngay_bat_dau=?, ngay_ket_thuc=? WHERE ma_du_an=" + ID;
        PreparedStatement preStmt = null;
        String Ten = jtfTenDuAn.getText();
        String MoTa = jtaMoTa.getText();
        String NgayBat = jtfNgayBatDau.getText();
        String NgayKet = jtfNgayKetThuc.getText();
        int row = 0;
        try {
            preStmt = cons.prepareStatement(sql);
            preStmt.setString(1, Ten);
            preStmt.setString(2, MoTa);
            preStmt.setString(3, NgayBat);
            preStmt.setString(4, NgayKet);
            row = preStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
            model.setRowCount(0);
            showDuAn();
            System.out.println("Row inserted" + row);
            cons.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        jtfTenDuAn.setText("");
        jtaMoTa.setText("");
        jtfNgayBatDau.setText("");
        jtfNgayKetThuc.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Connection cons = DBConnect.getConnection();
        String sql = "INSERT INTO du_an " + " VALUES (?, ?, ?, ?)";
        PreparedStatement preStmt = null;
        String Ten = jtfTenDuAn.getText();
        String MoTa = jtaMoTa.getText();
        String NgayBat = jtfNgayBatDau.getText();
        String NgayKet = jtfNgayKetThuc.getText();
        int row = 0;
        try {
            preStmt = cons.prepareStatement(sql);
            preStmt.setString(1, Ten);
            preStmt.setString(2, MoTa);
            preStmt.setString(3, NgayBat);
            preStmt.setString(4, NgayKet);
            row = preStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm mới thành công!");
            System.out.println("Row inserted" + row);
            DefaultTableModel model = (DefaultTableModel) jtbDuAn.getModel();
            model.setRowCount(0);
            showDuAn();
            cons.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }                          
    }//GEN-LAST:event_btnAddActionPerformed

    private void jtbDuAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbDuAnMouseClicked
       int rowIndex = jtbDuAn.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jtbDuAn.getModel();
        jtfTenDuAn.setText(model.getValueAt(rowIndex, 1).toString());
        jtaMoTa.setText(model.getValueAt(rowIndex, 2).toString());
        jtfNgayBatDau.setText(model.getValueAt(rowIndex, 3).toString());
        jtfNgayKetThuc.setText(model.getValueAt(rowIndex, 4).toString());
    }//GEN-LAST:event_jtbDuAnMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnView;
    private javax.swing.JTextArea jtaMoTa;
    private javax.swing.JTable jtbDuAn;
    private javax.swing.JTextField jtfNgayBatDau;
    private javax.swing.JTextField jtfNgayKetThuc;
    private javax.swing.JTextField jtfTenDuAn;
    // End of variables declaration//GEN-END:variables
}

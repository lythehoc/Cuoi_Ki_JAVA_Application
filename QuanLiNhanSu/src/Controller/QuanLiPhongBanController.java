package Controller;

import Service.NhanVienService;
import Service.NhanVienServiceImpl;
import Utility.ClassTableModel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.NhanVien;
import view.NhanVienJFrame;

public class QuanLiPhongBanController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
     private NhanVienService duAnService =null;
      private String[] listColumn = {"Mã nhân viên", "STT", "Tên nhân viên", "Ngày sinh",
        "Giới tính", "Số điện thoại", "Địa chỉ", "Trình trạng"};
      private TableRowSorter<TableModel> rowSorter = null;

    public QuanLiPhongBanController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public QuanLiDuAnController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public QuanLiNhanVienController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
         this.nhanVienService = new NhanVienServiceImpl();
    }
    public void setDateToTable(){
        List<NhanVien> ListItem  = nhanVienService.getList();
        DefaultTableModel model = new ClassTableModel().setTableNhanVien(ListItem, listColumn);
        final JTable table = new JTable(model);
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                  String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));             
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                  String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));   
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        table.getColumnModel().getColumn(1).setMinWidth(80);
        table.getColumnModel().getColumn(1).setMaxWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        
        table.addMouseListener(new MouseAdapter(){
    
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    NhanVien nhanVien = new NhanVien();
                    
                    nhanVien.setMa_nhan_vien((int) model.getValueAt(selectedRowIndex, 0));
                    nhanVien.setHo_ten ( model.getValueAt(selectedRowIndex, 2).toString());
                    nhanVien.setNgay_sinh((java.sql.Date) (Date) model.getValueAt(selectedRowIndex, 3));
                    nhanVien.setGioi_tinh(model.getValueAt(selectedRowIndex, 4).toString().equalsIgnoreCase("Nam"));
                    nhanVien.setSo_dien_thoai(model.getValueAt(selectedRowIndex, 5) != null ?
                            model.getValueAt(selectedRowIndex, 5).toString() : "");
                    nhanVien.setDia_chi(model.getValueAt(selectedRowIndex, 6) != null ?
                            model.getValueAt(selectedRowIndex, 6).toString() : "");
                    nhanVien.setTinh_trang((boolean) model.getValueAt(selectedRowIndex, 7));
                    
                    NhanVienJFrame frame = new NhanVienJFrame(nhanVien);
                    frame.setTitle("Thông tin nhân viên");
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            }
    });
        
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }
        public void setEvent(){
        btnAdd.addMouseListener(new MouseAdapter() {

             @Override
                public void mouseClicked(MouseEvent e) {
                   NhanVienJFrame frame = new NhanVienJFrame(new NhanVien());
                   frame.setTitle("Thông tin nhân viên");
                   frame.setLocationRelativeTo(null);
                   frame.setResizable(false);
                   frame.setVisible(true);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    btnAdd.setBackground(new Color(0, 200, 83));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                     btnAdd.setBackground(new Color(100, 221, 23));
                }
        });
        }      
}

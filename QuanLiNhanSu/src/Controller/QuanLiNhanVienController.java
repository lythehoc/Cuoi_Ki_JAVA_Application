package Controller;

import Service.NhanVienServiceImpl;
import Service.NhanVienService;
import Utility.ClassTableModel;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
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


public class QuanLiNhanVienController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
     private NhanVienService nhanVienService =null;
      private String[] listColumn = {"Mã nhân viên", "STT", "Tên nhân viên", "Ngày sinh",
        "Giới tính", "Số điện thoại", "Địa chỉ", "Trình trạng"};
      private TableRowSorter<TableModel> rowSorter = null;
    
    public QuanLiNhanVienController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
         this.nhanVienService = new NhanVienServiceImpl();
    }
    public void setDateToTable(){
        List<NhanVien> ListItem  = nhanVienService.getList();
        DefaultTableModel model = new ClassTableModel().setTableNhanVien(ListItem, listColumn);
        JTable table = new JTable(model);
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
}

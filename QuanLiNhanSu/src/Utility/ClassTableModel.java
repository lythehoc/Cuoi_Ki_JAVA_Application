package Utility;

import javax.swing.table.DefaultTableModel;
import model.NhanVien;
import java.util.List;

public class ClassTableModel {
    public DefaultTableModel setTableNhanVien( List<NhanVien> listItem, String[] listColumn){
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 7 ? Boolean.class : String.class;
            }
            
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns   = listColumn.length;
        Object[] obj = null;
        int rows =listItem.size();
        if(rows > 0){
            for (int i=0; i< rows; i++){
                NhanVien nhanVien = listItem.get(i);
                obj = new Object[columns];
                obj[0] = nhanVien.getMa_nhan_vien();
                obj[1] = (i + 1);
                obj[2] = nhanVien.getHo_ten();
                obj[3] = nhanVien.getNgay_sinh();
                obj[4] = nhanVien.isGioi_tinh() == true ? "Nam" : "Nữ";
                obj[5] = nhanVien.getSo_dien_thoai();
                obj[6] = nhanVien.getDia_chi();
                obj[7] = nhanVien.isTinh_trang();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
}

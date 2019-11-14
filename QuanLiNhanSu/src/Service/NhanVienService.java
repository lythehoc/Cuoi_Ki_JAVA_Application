package Service;

import java.util.List;
import model.NhanVien;

public interface NhanVienService {
    public List<NhanVien> getList();
    public int createOrUpdate(NhanVien nhanVien);
}

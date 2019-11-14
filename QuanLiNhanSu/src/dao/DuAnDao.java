package dao;

import java.util.List;
import model.NhanVien;

public interface DuAnDao {
    public List<DuAn> getList();
    public int createOrUpdate(DuAn duAn);
}

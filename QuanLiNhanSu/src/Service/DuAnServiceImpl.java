package Service;

import java.util.List;
import model.NhanVien;

public class DuAnServiceImpl DuAnService{
    private DuAnDao duAnDao = null;
    public DuAnServiceImpl(){
     this.duAnDao = new DuAnDaoImpl();
    }
    
    @Override
    public List<NhanVien> getList() {
        return duAnDao.getList();
    }

    @Override
    public int createOrUpdate(NhanVien nhanVien) {
        return duAnDao.createOrUpdate(nhanVien);
    }
}

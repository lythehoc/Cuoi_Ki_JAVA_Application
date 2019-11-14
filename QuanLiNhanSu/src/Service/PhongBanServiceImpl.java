package Service;

import dao.NhanVienDao;
import dao.NhanVienDaoImpl;
import java.util.List;
import model.NhanVien;

public class NhanVienServiceImpl implements NhanVienService{

    private NhanVienDao nhanVienDao = null;
    public NhanVienServiceImpl(){
     this.nhanVienDao = new NhanVienDaoImpl();
    }
    
    @Override
    public List<NhanVien> getList() {
        return nhanVienDao.getList();
    }

    @Override
    public int createOrUpdate(NhanVien nhanVien) {
        return nhanVienDao.createOrUpdate(nhanVien);
    }
}
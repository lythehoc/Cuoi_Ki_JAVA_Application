/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

package SNATB.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SNATB.DAO.AdminDAO;
import SNATB.DAO.DAO;
import SNATB.Entity.Admin;
@Service
public class AdminService extends DAO<Admin, String> {

	@Autowired
	AdminDAO adminDao;
	
	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return adminDao.findAll();
	}

	@Override
	public Admin findById(String username) {
		// TODO Auto-generated method stub
		return adminDao.findById(username).get();
	}

	@Override
	public Admin save(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.save(admin);
	}

	@Override
	public void deleteById(String username) {
		// TODO Auto-generated method stub
		adminDao.deleteById(username);
	}


	@Override
	public boolean existsBy(String username) {
		// TODO Auto-generated method stub
		return adminDao.existsById(username);
	}
	
//	public long countAccount() {
//		// TODO Auto-generated method stub
//		return adminDao.count();
//	}
	
//	public Account validateLogin(String username, String password) {
//        return accountDao.findById(username)
//                .filter(account -> account.getPassword().equals(password))
//                .orElse(null);
//    }

}

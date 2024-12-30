package SNATB.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SNATB.DAO.AccountDAO;
import SNATB.DAO.DAO;
import SNATB.Entity.Account;


@Service
public class AccountService extends DAO<Account, String> {

	@Autowired
	AccountDAO accountDao;
	
	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return accountDao.findAll();
	}

	@Override
	public Account findById(String username) {
		// TODO Auto-generated method stub
		return accountDao.findById(username).get();
	}

	@Override
	public Account save(Account account) {
		// TODO Auto-generated method stub
		return accountDao.save(account);
	}

	@Override
	public void deleteById(String username) {
		// TODO Auto-generated method stub
		accountDao.deleteById(username);
	}


	@Override
	public boolean existsBy(String username) {
		// TODO Auto-generated method stub
		return accountDao.existsById(username);
	}
	
	public long countAccount() {
		// TODO Auto-generated method stub
		return accountDao.count();
	}
	
//	public Account validateLogin(String username, String password) {
//        return accountDao.findById(username)
//                .filter(account -> account.getPassword().equals(password))
//                .orElse(null);
//    }

}

package SNATB.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
		// Gán giá trị mặc định cho một số trường
		account.setCreatedDate(LocalDateTime.now());
		account.setUpdateDate(LocalDateTime.now());
		account.setStatus(true);
		account.setVip(false);
		Account savedAccount = accountDao.save(account);
		return savedAccount;
	}

	@Override
	public void deleteById(String username) {
		// TODO Auto-generated method stub
		accountDao.deleteById(username);
	}

	public Account validateLogin(String username, String password) {
		Account account = accountDao.findById(username).orElse(null);
		if (account != null && account.getPassword().equals(password)) {
			return account; // Đăng nhập thành công
		}
		return null; // Đăng nhập thất bại
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

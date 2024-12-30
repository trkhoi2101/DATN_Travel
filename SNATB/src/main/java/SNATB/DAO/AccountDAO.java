package SNATB.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SNATB.Entity.Account;



@Repository
public interface AccountDAO extends JpaRepository<Account,String>{
	long count();
}

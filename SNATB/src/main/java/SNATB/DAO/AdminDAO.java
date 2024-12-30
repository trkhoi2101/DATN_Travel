package SNATB.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SNATB.Entity.Admin;



@Repository
public interface AdminDAO extends JpaRepository<Admin,String>{
	long count();
}

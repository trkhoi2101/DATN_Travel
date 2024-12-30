package SNATB.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SNATB.Entity.Tour;



@Repository
public interface TourDAO extends JpaRepository<Tour,Long>{
	
}

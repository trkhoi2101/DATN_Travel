package SNATB.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SNATB.Entity.Schedule;

@Repository
public interface ScheduleDAO extends JpaRepository<Schedule,String>{

}

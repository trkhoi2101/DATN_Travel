package SNATB.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SNATB.DAO.DAO;
import SNATB.DAO.ScheduleDAO;
import SNATB.Entity.Schedule;
@Service
public class ScheduleService extends DAO<Schedule, String> {

	@Autowired
	ScheduleDAO scheduleDao;
	
	@Override
	public List<Schedule> findAll() {
		// TODO Auto-generated method stub
		return scheduleDao.findAll();
	}

	@Override
	public Schedule findById(String scheduleId) {
		// TODO Auto-generated method stub
		return scheduleDao.findById(scheduleId).get();
	}

	@Override
	public Schedule save(Schedule schedule) {
		// TODO Auto-generated method stub
		return scheduleDao.save(schedule);
	}

	@Override
	public void deleteById(String scheduleId) {
		// TODO Auto-generated method stub
		scheduleDao.deleteById(scheduleId);
	}


	@Override
	public boolean existsBy(String scheduleId) {
		// TODO Auto-generated method stub
		return scheduleDao.existsById(scheduleId);
	}

}

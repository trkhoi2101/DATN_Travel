package SNATB.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SNATB.DAO.DAO;
import SNATB.DAO.TourDAO;
import SNATB.Entity.Tour;
@Service
public class TourService extends DAO<Tour, Long> {

	@Autowired
	TourDAO tourDao;
	
	@Override
	public List<Tour> findAll() {
		// TODO Auto-generated method stub
		return tourDao.findAll();
	}

	@Override
	public Tour findById(Long tourId) {
		// TODO Auto-generated method stub
		return tourDao.findById(tourId).get();
	}

	@Override
	public Tour save(Tour tour) {
		// TODO Auto-generated method stub
		return tourDao.save(tour);
	}

	@Override
	public void deleteById(Long tourId) {
		// TODO Auto-generated method stub
		tourDao.deleteById(tourId);
	}


	@Override
	public boolean existsBy(Long tourId) {
		// TODO Auto-generated method stub
		return tourDao.existsById(tourId);
	}

}

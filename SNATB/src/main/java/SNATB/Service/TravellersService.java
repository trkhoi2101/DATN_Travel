package SNATB.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SNATB.DAO.DAO;
import SNATB.DAO.TravellerDAO;
import SNATB.Entity.Traveller;
@Service
public class TravellersService extends DAO<Traveller, Long> {

	@Autowired
	TravellerDAO travellerDao;
	
	@Override
	public List<Traveller> findAll() {
		// TODO Auto-generated method stub
		return travellerDao.findAll();
	}

	@Override
	public Traveller findById(Long travellerId) {
		// TODO Auto-generated method stub
		return travellerDao.findById(travellerId).get();
	}

	@Override
	public Traveller save(Traveller traveller) {
		// TODO Auto-generated method stub
		return travellerDao.save(traveller);
	}

	@Override
	public void deleteById(Long travellerId) {
		// TODO Auto-generated method stub
		travellerDao.deleteById(travellerId);
	}


	@Override
	public boolean existsBy(Long travellerId) {
		// TODO Auto-generated method stub
		return travellerDao.existsById(travellerId);
	}

}

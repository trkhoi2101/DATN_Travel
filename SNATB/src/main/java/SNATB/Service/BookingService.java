package SNATB.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SNATB.DAO.BookingDAO;
import SNATB.DAO.DAO;
import SNATB.Entity.Booking;


@Service
public class BookingService extends DAO<Booking, Long> {

	@Autowired
	BookingDAO bookingDao;
	
	@Override
	public List<Booking> findAll() {
		// TODO Auto-generated method stub
		return bookingDao.findAll();
	}

	@Override
	public Booking findById(Long bookingId) {
		// TODO Auto-generated method stub
		return bookingDao.findById(bookingId).get();
	}

	@Override
	public Booking save(Booking booking) {
		// TODO Auto-generated method stub
		return bookingDao.save(booking);
	}

	@Override
	public void deleteById(Long bookingId) {
		// TODO Auto-generated method stub
		bookingDao.deleteById(bookingId);
	}


	@Override
	public boolean existsBy(Long bookingId) {
		// TODO Auto-generated method stub
		return bookingDao.existsById(bookingId);
	}
	
//	public Object[] findTopTourDetail() {
//        List<Object[]> results = bookingDao.findTopTourDetail();
//        return results.isEmpty() ? null : results.get(0);
//    }

}

//package SNATB.Service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import SNATB.DAO.DAO;
//import SNATB.DAO.InvoiceDAO;
//import SNATB.Entity.Invoice;
//@Service
//public class InvoiceService extends DAO<Invoice,Long> {
//
//	@Autowired
//	InvoiceDAO invoiceDao;
//	
//	@Override
//	public List<Invoice> findAll() {
//		// TODO Auto-generated method stub
//		return invoiceDao.findAll();
//	}
//
//	@Override
//	public Invoice findById(Long invoiceId) {
//		// TODO Auto-generated method stub
//		return invoiceDao.findById(invoiceId).get();
//	}
//
//	@Override
//	public Invoice save(Invoice invoice) {
//		// TODO Auto-generated method stub
//		return invoiceDao.save(invoice);
//	}
//
//	@Override
//	public void deleteById(Long invoiceId) {
//		// TODO Auto-generated method stub
//		invoiceDao.deleteById(invoiceId);
//	}
//
//
//	@Override
//	public boolean existsBy(Long invoiceId) {
//		// TODO Auto-generated method stub
//		return invoiceDao.existsById(invoiceId);
//	}
//
//}

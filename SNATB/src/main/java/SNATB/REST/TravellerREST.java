//package com.blogdulich.REST;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.blogdulich.DAO.BookingDAO;
//import com.blogdulich.entity.Booking;
//
//@RestController
//@RequestMapping(path = "/rest")
//public class BookingREST {
//	@Autowired
//	BookingDAO bookingDao;
//	
//	@GetMapping(path = "/booking")
//	public List<Booking> getAll() {
//		return bookingDao.findAll();
//	}
//	
//
//
////    @GetMapping(path = "/booking/{id}")
////    public Booking getBookingById(@PathVariable("id") String bookingId) {
////        return bookingdao.findById(bookingId).get();
////    }
////
////    @PostMapping(path = "/booking")
////    public Booking createBooking(@RequestBody Booking booking) {
////        return bookingdao.save(booking);
////    }
////
////    @PutMapping(path = "/booking/{id}")
////    public Booking updateBooking(@PathVariable("id") String bookingId, @RequestBody Booking booking) {
////        return bookingdao.save(booking);
////    }
////
////    @DeleteMapping(path = "/booking/{id}")
////    public void deleteBooking(@PathVariable("id") String bookingId) {
////    	bookingdao.deleteById(bookingId);
////    }
//}
package SNATB.REST;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import SNATB.Entity.Traveller;
import SNATB.Service.TravellersService;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/REST/traveller")
public class TravellerREST {

    @Autowired
    private TravellersService travellerService;

    @GetMapping
    public List<Traveller> getAllTraveller() {
        return travellerService.findAll();
    }

    @GetMapping("/{id}")
    public Traveller getTravellerById(@PathVariable("id") Long travellerId) {
        return travellerService.findById(travellerId);
    }

    @PostMapping
    public Traveller createTraveller(@RequestBody Traveller traveller) {
        return travellerService.save(traveller);
    }
    
    @PutMapping("/{id}")
    public Traveller updateTravellerById(@PathVariable("id") Long travelersid, @RequestBody Traveller traveller) {
    	return travellerService.save(traveller);
    }

    @DeleteMapping("/{id}")
    public void deleteTraveller(@PathVariable("id") Long travellerId) {
    	travellerService.deleteById(travellerId);
    }
}

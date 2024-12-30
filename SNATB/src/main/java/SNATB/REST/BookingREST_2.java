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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import SNATB.DTO.BookingRequest;
import SNATB.Entity.Booking;
import SNATB.Service.BookingService;
import SNATB.Service.BookingService_2;
import SNATB.Service.ScheduleService;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("user/REST/booking")
public class BookingREST_2 {
	
	@Autowired
    private BookingService_2 bookingService;

	
	@PostMapping("/create")
    public ResponseEntity<String> createBooking(@RequestBody BookingRequest bookingRequest) {
        try {
            bookingService.createBooking(bookingRequest);
            return ResponseEntity.ok("Booking created successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create booking: " + e.getMessage());
        }
    }
   
}

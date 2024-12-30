package SNATB.REST;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import SNATB.Entity.Tour;
import SNATB.Service.TourService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/REST/tour")
public class TourREST {

    @Autowired
    private TourService tourService;

    // Lấy tất cả Tours
    @GetMapping
    public List<Tour> getAllTour() {
        return tourService.findAll();
    }

    // Lấy Tour theo ID
    @GetMapping("/{id}")
    public Tour getTourById(@PathVariable("id") Long tourId) {
        return tourService.findById(tourId);
    }

    // Tạo Tour mới
    @PostMapping
    public Tour createTour(@RequestBody Tour tour) {
        return tourService.save(tour);
    }

    // Cập nhật Tour
    @PutMapping("/{id}")
    public Tour updateTour(@PathVariable("id") Long tourId, @RequestBody Tour tour) {
        tour.setTourId(tourId); // Đảm bảo ID không thay đổi
        return tourService.save(tour);
    }

    // Xóa Tour
    @DeleteMapping("/{id}")
    public void deleteTour(@PathVariable("id") Long tourId) {
    	tourService.deleteById(tourId);
    }
}

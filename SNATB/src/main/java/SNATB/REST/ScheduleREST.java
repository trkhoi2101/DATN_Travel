package SNATB.REST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import SNATB.Entity.Schedule;
import SNATB.Service.ScheduleService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/REST/schedule")
public class ScheduleREST {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping
    public List<Schedule> getAllSchedule() {
        return scheduleService.findAll();
    }

    @GetMapping("/{id}")
    public Schedule getScheduleById(@PathVariable("id") String scheduleId) {
        return scheduleService.findById(scheduleId);
    }

    @PostMapping
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return scheduleService.save(schedule);
    }

    @PutMapping("/{id}")
    public Schedule updateSchedule(@PathVariable("id") String scheduleId, @RequestBody Schedule schedule) {
        schedule.setScheduleId(scheduleId);
        return scheduleService.save(schedule);
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable("id") String scheduleId) {
        scheduleService.deleteById(scheduleId);
    }
}

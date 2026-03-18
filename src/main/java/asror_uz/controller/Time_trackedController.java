package asror_uz.controller;

import asror_uz.dto.Time_trackedDto;
import asror_uz.model.Result;
import asror_uz.model.Time_tracked;
import asror_uz.service.Time_trackedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/time_tracked")
public class Time_trackedController {

    @Autowired
    Time_trackedService service;

    @PostMapping
    public Result create(@RequestBody Time_trackedDto dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public Time_tracked getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Time_tracked> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody Time_trackedDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return service.delete(id);
    }
}

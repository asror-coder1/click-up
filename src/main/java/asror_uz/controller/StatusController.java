package asror_uz.controller;

import asror_uz.dto.StatusDto;
import asror_uz.model.Result;
import asror_uz.model.Status;
import asror_uz.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    @Autowired
    StatusService service;

    @PostMapping
    public Result create(@RequestBody StatusDto dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public Status getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Status> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody StatusDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return service.delete(id);
    }
}

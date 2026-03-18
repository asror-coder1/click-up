package asror_uz.controller;

import asror_uz.dto.PriorityDto;
import asror_uz.model.Priority;
import asror_uz.model.Result;
import asror_uz.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/priority")
public class PriorityController {

    @Autowired
    PriorityService service;

    @PostMapping
    public Result create(@RequestBody PriorityDto dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public Priority getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Priority> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody PriorityDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return service.delete(id);
    }
}

package asror_uz.controller;

import asror_uz.dto.Task_dependencyDto;
import asror_uz.model.Result;
import asror_uz.model.Task_dependency;
import asror_uz.service.Task_dependencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task_dependency")
public class Task_dependencyController {

    @Autowired
    Task_dependencyService service;

    @PostMapping
    public Result create(@RequestBody Task_dependencyDto dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public Task_dependency getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Task_dependency> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody Task_dependencyDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return service.delete(id);
    }
}

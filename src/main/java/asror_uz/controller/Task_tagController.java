package asror_uz.controller;

import asror_uz.dto.Task_tagDto;
import asror_uz.model.Result;
import asror_uz.model.Task_tag;
import asror_uz.service.Task_tagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task_tag")
public class Task_tagController {

    @Autowired
    Task_tagService service;

    @PostMapping
    public Result create(@RequestBody Task_tagDto dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public Task_tag getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Task_tag> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody Task_tagDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return service.delete(id);
    }
}

package asror_uz.controller;

import asror_uz.dto.Task_attachmentDto;
import asror_uz.model.Result;
import asror_uz.model.Task_attachment;
import asror_uz.service.Task_attachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task_attachment")
public class Task_attachmentController {

    @Autowired
    Task_attachmentService service;

    @PostMapping
    public Result create(@RequestBody Task_attachmentDto dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public Task_attachment getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Task_attachment> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody Task_attachmentDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return service.delete(id);
    }
}

package asror_uz.controller;

import asror_uz.dto.CommentDto;
import asror_uz.model.Comment;
import asror_uz.model.Result;
import asror_uz.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    CommentService service;

    @PostMapping
    public Result create(@RequestBody CommentDto dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public Comment getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Comment> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody CommentDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return service.delete(id);
    }
}

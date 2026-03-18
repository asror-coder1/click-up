package asror_uz.controller;

import asror_uz.dto.TagDto;
import asror_uz.model.Result;
import asror_uz.model.Tag;
import asror_uz.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tag")
public class TagController {

    @Autowired
    TagService service;

    @PostMapping
    public Result create(@RequestBody TagDto dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public Tag getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Tag> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody TagDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return service.delete(id);
    }
}

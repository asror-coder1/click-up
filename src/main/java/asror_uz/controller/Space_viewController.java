package asror_uz.controller;

import asror_uz.dto.Space_viewDto;
import asror_uz.model.Result;
import asror_uz.model.Space_view;
import asror_uz.service.Space_viewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/space_view")
public class Space_viewController {

    @Autowired
    Space_viewService service;

    @PostMapping
    public Result create(@RequestBody Space_viewDto dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public Space_view getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Space_view> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody Space_viewDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return service.delete(id);
    }
}

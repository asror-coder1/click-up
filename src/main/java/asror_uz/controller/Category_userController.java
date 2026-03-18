package asror_uz.controller;

import asror_uz.dto.Category_userDto;
import asror_uz.model.Category_user;
import asror_uz.model.Result;
import asror_uz.service.Category_userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category_user")
public class Category_userController {

    @Autowired
    Category_userService service;

    @PostMapping
    public Result create(@RequestBody Category_userDto dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public Category_user getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Category_user> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody Category_userDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return service.delete(id);
    }
}

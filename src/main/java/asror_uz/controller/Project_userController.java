package asror_uz.controller;

import asror_uz.dto.Project_userDto;
import asror_uz.model.Project_user;
import asror_uz.model.Result;
import asror_uz.service.Project_userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project_user")
public class Project_userController {

    @Autowired
    Project_userService service;

    @PostMapping
    public Result create(@RequestBody Project_userDto dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public Project_user getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Project_user> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody Project_userDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return service.delete(id);
    }
}

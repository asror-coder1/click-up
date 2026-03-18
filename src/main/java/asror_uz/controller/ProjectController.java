package asror_uz.controller;

import asror_uz.dto.ProjectDto;
import asror_uz.model.Project;
import asror_uz.model.Result;
import asror_uz.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    ProjectService service;

    @PostMapping
    public Result create(@RequestBody ProjectDto dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public Project getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Project> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody ProjectDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return service.delete(id);
    }
}

package asror_uz.controller;

import asror_uz.dto.Workspace_permissionDto;
import asror_uz.model.Result;
import asror_uz.model.Workspace_permission;
import asror_uz.service.Workspace_permissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workspace_permission")
public class Workspace_permissionController {

    @Autowired
    Workspace_permissionService service;

    @PostMapping()
    public Result add(@RequestBody Workspace_permissionDto dto){
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public Workspace_permission getId(@PathVariable Long id){
        return service.getById(id);
    }

    @GetMapping
    public List<Workspace_permission> getAll(){
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Long id , @RequestBody Workspace_permissionDto dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        return service.delete(id);
    }
}

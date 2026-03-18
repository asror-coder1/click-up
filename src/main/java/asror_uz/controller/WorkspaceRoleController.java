package asror_uz.controller;

import asror_uz.dto.WorkspaceRoleDto;
import asror_uz.model.Result;
import asror_uz.model.WorkspaceRole;
import asror_uz.service.WorkspaceRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workspace_role")
public class WorkspaceRoleController {
    @Autowired
    WorkspaceRoleService service;

    @PostMapping
    public Result add(@RequestBody WorkspaceRoleDto dto){
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public WorkspaceRole getbyId(@PathVariable Long id){
        return service.getbyId(id);
    }

    @GetMapping
    public List<WorkspaceRole> getAll(){
        List<WorkspaceRole> all = service.getAll();
        return all;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Long id , @RequestBody WorkspaceRoleDto dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        return service.delete(id);
    }
}

package asror_uz.controller;

import asror_uz.dto.WorkspaceUserDto;
import asror_uz.model.Result;
import asror_uz.model.WorkspaceUser;
import asror_uz.service.WorkspaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workspace_user")
public class WorkspaceUserController {

    @Autowired
    WorkspaceUserService service;

    @PostMapping
    public Result add(@RequestBody WorkspaceUserDto dto){
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public WorkspaceUser getbyId(@PathVariable Long id){
        WorkspaceUser workspaceUser = service.readById(id);
        return workspaceUser;
    }

    @GetMapping
    public List<WorkspaceUser> getaLL(){
        List<WorkspaceUser> all = service.getAll();
        return all;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Long id , @RequestBody WorkspaceUserDto dto){
       return service.update(id , dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        return service.delete(id);
    }
}

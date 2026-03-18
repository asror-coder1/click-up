package asror_uz.controller;

import asror_uz.dto.WorkspaceDto;
import asror_uz.model.Result;
import asror_uz.model.Workspace;
import asror_uz.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workspace")
public class WorkspaceController {

    @Autowired
    WorkspaceService service;

    @PostMapping
    public Result add(@RequestBody WorkspaceDto dto){
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public Workspace byId(@PathVariable Long id){
        Workspace byId = service.getById(id);
        return byId;
    }

    @GetMapping
    public List<Workspace> getAll(){
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id , @RequestBody WorkspaceDto dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        return service.delete(id);
    }
}

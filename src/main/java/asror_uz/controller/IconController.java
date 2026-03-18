package asror_uz.controller;

import asror_uz.dto.IconDto;
import asror_uz.model.Icon;
import asror_uz.model.Result;
import asror_uz.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/input")
public class IconController {
    @Autowired
    IconService service;

    @PostMapping
    public Result add (@RequestBody IconDto dto){
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public Icon getBYid(@PathVariable Long id){
        Icon byId = service.getById(id);
        return byId;
    }

    @GetMapping
    public List<Icon> getAll(){
        List<Icon> all = service.getAll();
        return all;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Long id , @RequestBody IconDto dto){
        Result update = service.update(id, dto);
        return update;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        return service.delete(id);
    }
}

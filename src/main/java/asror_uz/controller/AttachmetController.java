package asror_uz.controller;

import asror_uz.dto.AttachmetDto;
import asror_uz.model.Attachmet;
import asror_uz.model.Result;
import asror_uz.service.AttachmetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attachmet")
public class AttachmetController {
    @Autowired
    AttachmetService service;

    @PostMapping
    public Result add(@RequestBody AttachmetDto dto) {
        Result result = service.create(dto);
        return result;
    }

    @GetMapping("/{id}")
    public Attachmet getByid(@PathVariable Long id){
        return service.byid(id);
    }

    @GetMapping
    public List<Attachmet> getAll(){
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Long id , @RequestBody AttachmetDto dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        Result delete = service.delete(id);
        return delete;
    }
}

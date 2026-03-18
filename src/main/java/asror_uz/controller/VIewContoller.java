package asror_uz.controller;

import asror_uz.dto.ViewDto;
import asror_uz.model.Result;
import asror_uz.model.VIew;
import asror_uz.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/view")
public class VIewContoller {

    @Autowired
    ViewService service;

    // CREATE
    @PostMapping
    public Result create(@RequestBody ViewDto dto){
        return service.create(dto);
    }

    // GET ALL
    @GetMapping
    public List<VIew> getAll(){
        return service.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public VIew getById(@PathVariable Long id){
        return service.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody ViewDto dto){
        return service.update(id, dto);
    }


    // DELETE
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        return service.delete(id);
    }
}
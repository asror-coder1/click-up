package asror_uz.controller;

import asror_uz.dto.Check_listDto;
import asror_uz.model.Check_list;
import asror_uz.model.Result;
import asror_uz.service.Check_listService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/check_list")
public class Check_listController {

    @Autowired
    Check_listService service;

    @PostMapping
    public Result create(@RequestBody Check_listDto dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public Check_list getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Check_list> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody Check_listDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return service.delete(id);
    }
}

package asror_uz.controller;

import asror_uz.dto.Check_list_itemDto;
import asror_uz.model.Check_list_item;
import asror_uz.model.Result;
import asror_uz.service.Check_list_itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/check_list_item")
public class Check_list_itemController {

    @Autowired
    Check_list_itemService service;

    @PostMapping
    public Result create(@RequestBody Check_list_itemDto dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public Check_list_item getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Check_list_item> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody Check_list_itemDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return service.delete(id);
    }
}

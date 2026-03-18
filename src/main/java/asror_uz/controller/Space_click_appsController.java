package asror_uz.controller;

import asror_uz.dto.Space_click_appsDto;
import asror_uz.model.Result;
import asror_uz.model.Space_click_apps;
import asror_uz.service.Space_click_appsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/space_click_apps")
public class Space_click_appsController {

    @Autowired
    Space_click_appsService service;

    @PostMapping
    public Result create(@RequestBody Space_click_appsDto dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public Space_click_apps getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Space_click_apps> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody Space_click_appsDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return service.delete(id);
    }
}

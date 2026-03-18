package asror_uz.controller;

import asror_uz.dto.SpaceDto;
import asror_uz.model.Result;
import asror_uz.model.Space;
import asror_uz.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/space")
public class SpaceController {

    @Autowired
    SpaceService service;

    @PostMapping
    public Result add(@RequestBody SpaceDto dto) {
        Result result = service.create(dto);
        return result;
    }

    @GetMapping("/{id}")
    public Space ById(@PathVariable Long id) {
        Space byId = service.getById(id);
        return byId;
    }

    @GetMapping
    public List<Space> getAll() {
        List<Space> all = service.getAll();
        return all;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Long id, @RequestBody SpaceDto dto) {
        Result update = service.update(id, dto);
        return update;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return service.delete(id);
    }

}

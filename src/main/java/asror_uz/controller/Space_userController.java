package asror_uz.controller;

import asror_uz.dto.SpaceDto;
import asror_uz.dto.Space_userDto;
import asror_uz.model.Result;
import asror_uz.model.Space;
import asror_uz.model.Space_user;
import asror_uz.service.Space_userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/space_user")
public class Space_userController {
    @Autowired
    Space_userService service;

    @PostMapping
    public Result add(@RequestBody Space_userDto dto) {
        Result result = service.create(dto);
        return result;
    }

    @GetMapping("/{id}")
    public Space_user ById(@PathVariable Long id) {
       return service.getById(id);
    }

    @GetMapping
    public List<Space_user> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Long id, @RequestBody Space_userDto dto) {
        Result update = service.update(id, dto);
        return update;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        return service.delete(id);
    }

}

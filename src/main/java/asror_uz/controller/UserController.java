package asror_uz.controller;

import asror_uz.dto.UserDto;
import asror_uz.model.Result;
import asror_uz.model.User;
import asror_uz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    // CREATE
    @PostMapping
    public Result create(@RequestBody UserDto dto){
        return service.create(dto);
    }

    // GET ALL
    @GetMapping
    public List<User> getAll(){
        return service.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return service.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Result update(@PathVariable Long id , @RequestBody UserDto dto){
        return service.update(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        return service.delete(id);
    }

}
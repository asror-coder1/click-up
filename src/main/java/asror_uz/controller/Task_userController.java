package asror_uz.controller;

import asror_uz.dto.Task_userDto;
import asror_uz.model.Result;
import asror_uz.model.Task_user;
import asror_uz.service.Task_userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task_user")
public class Task_userController {
    @Autowired
    Task_userService service;

    @PostMapping
    public Result add(@RequestBody Task_userDto dto){
        Result result = service.create(dto);
        return result;
    }

    @GetMapping("/{id}")
    public Task_user byId(@PathVariable Long id){
        return service.getById(id);
    }

    @GetMapping

    public List<Task_user> getALl(){
        List<Task_user> all = service.getAll();
        return all;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Long id , @RequestBody Task_userDto dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        return service.delete(id);
    }

}

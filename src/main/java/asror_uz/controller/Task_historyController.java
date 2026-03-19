package asror_uz.controller;

import asror_uz.dto.Task_historyDto;
import asror_uz.model.Result;
import asror_uz.model.Task_history;
import asror_uz.service.Task_historyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task_history")
public class Task_historyController {

    @Autowired
    Task_historyService service;

    @PostMapping
    public Result create(@RequestBody Task_historyDto dto){
        return service.create(dto);
    }

    @GetMapping
    public List<Task_history> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Task_history getById(@PathVariable Long id) {
        return service.getById(id);
    }

        @PutMapping("/{id}")
        public Result update(@PathVariable Long id, @RequestBody Task_historyDto dto){
            return service.update(id, dto);
        }

        @DeleteMapping("/{id}")
        public Result delete(@PathVariable Long id){
            return service.delete(id);
        }
}

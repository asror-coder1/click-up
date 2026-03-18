package asror_uz.controller;

import asror_uz.dto.Click_appsDto;
import asror_uz.model.Click_apps;
import asror_uz.model.Result;
import asror_uz.service.ClickApps_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/click_apps")
public class Click_AppsCOntoller {

    @Autowired
    ClickApps_service service;

    @PostMapping
    public Result add(@RequestBody Click_appsDto dto){
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public Click_apps byId(@PathVariable Long id){
        Click_apps byId = service.getById(id);
        return byId;
    }

    @GetMapping
    public List<Click_apps> getAll(){
        List<Click_apps> all = service.getAll();
        return all;
    }

    @PutMapping("/{id}")
    public Result edit(@PathVariable Long id , @RequestBody Click_appsDto dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")

    public Result delete(@PathVariable Long id){
        Result delete = service.delete(id);
        return delete;
    }
}

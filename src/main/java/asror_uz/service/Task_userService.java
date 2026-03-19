package asror_uz.service;

import asror_uz.dto.Task_userDto;
import asror_uz.model.Result;
import asror_uz.model.Task_user;
import asror_uz.repository.Task_userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Task_userService {
    @Autowired
    Task_userRepo repo;

    public Result create(Task_userDto dto){
        Task_user taskUser = new Task_user();
        taskUser.setTask_id(dto.getTask_id());
        taskUser.setUser_id(dto.getUser_id());
        repo.save(taskUser);

        return new Result("Saqlandi" , true);
    }

    public Task_user getById(Long id){
        Optional<Task_user> byId = repo.findById(id);
        return byId.orElse(null);
    }

    public List<Task_user> getAll(){
        return repo.findAll();
    }

    public Result update(Long id , Task_userDto dto){
        Optional<Task_user> optional = repo.findById(id);
        if (optional.isPresent()){
            Task_user taskUser = optional.get();
            taskUser.setTask_id(dto.getTask_id());
            taskUser.setUser_id(dto.getUser_id());
            repo.save(taskUser);

            return new Result("Updated" , true);
        }
        return new Result("Id topilmadi" , false);
    }

    public Result delete(Long id){
        Optional<Task_user> byId = repo.findById(id);
        if (byId.isPresent()){
            repo.deleteById(id);

            return new Result("Deleted" , true);
        }
        return new Result("Id topilmadi" , false);
    }
}

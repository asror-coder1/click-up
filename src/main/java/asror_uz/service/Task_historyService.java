package asror_uz.service;

import asror_uz.dto.Task_historyDto;
import asror_uz.model.Result;
import asror_uz.model.Task_history;
import asror_uz.repository.Task_historyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Task_historyService {

    @Autowired
    Task_historyRepo repo;

    // CREATE
    public Result create(Task_historyDto dto){
        Task_history taskHistory = new Task_history();
        taskHistory.setTask_id(dto.getTask_id());
        taskHistory.setChange_field_name(dto.getChange_field_name());
        taskHistory.setBefore(dto.getBefore());
        taskHistory.setAfter(dto.getAfter());
        taskHistory.setDate(dto.getDate());
        repo.save(taskHistory);
        return new Result("Saqlandi", true);
    }

    // GET ALL

    public List<Task_history> getAll(){
        return repo.findAll();
    }

    // GET BY ID

    public Task_history getById(Long id){
        return repo.findById(id).orElse(null);
    }
    // UPDATE

    public Result update(Long id, Task_historyDto dto){
        Task_history taskHistory = repo.findById(id).orElse(null);
        if (taskHistory == null){
            return new Result("Topilmadi", false);
        }

        taskHistory.setTask_id(dto.getTask_id());
        taskHistory.setChange_field_name(dto.getChange_field_name());
        taskHistory.setBefore(dto.getBefore());
        taskHistory.setAfter(dto.getAfter());
        taskHistory.setDate(dto.getDate());
        repo.save(taskHistory);
        return new Result("O'zgartirildi", true);
    }

    // DELETE

    public Result delete(Long id){
        Task_history taskHistory = repo.findById(id).orElse(null);
        if (taskHistory == null){
            return new Result("Topilmadi", false);
        }
        repo.delete(taskHistory);
        return new Result("O'chirildi", true);
    }
}

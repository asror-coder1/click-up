package asror_uz.service;

import asror_uz.dto.Check_listDto;
import asror_uz.model.Check_list;
import asror_uz.model.Result;
import asror_uz.model.Task;
import asror_uz.repository.Check_listRepo;
import asror_uz.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Check_listService {

    @Autowired
    Check_listRepo repo;
    @Autowired
    TaskRepo taskRepo;

    public Result create(Check_listDto dto) {
        Check_list checkList = new Check_list();
        checkList.setName(dto.getName());
        if (dto.getTask_id() != null) {
            Optional<Task> taskOptional = taskRepo.findById(dto.getTask_id());
            taskOptional.ifPresent(checkList::setTask);
        }
        repo.save(checkList);
        return new Result("Check_list created", true);
    }

    public Check_list getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Check_list> getAll() {
        return repo.findAll();
    }

    public Result update(Long id, Check_listDto dto) {
        Optional<Check_list> optional = repo.findById(id);
        if (optional.isPresent()) {
            Check_list checkList = optional.get();
            checkList.setName(dto.getName());
            if (dto.getTask_id() != null) {
                Optional<Task> taskOptional = taskRepo.findById(dto.getTask_id());
                taskOptional.ifPresent(checkList::setTask);
            }
            repo.save(checkList);
            return new Result("Check_list updated", true);
        }
        return new Result("Check_list not found", false);
    }

    public Result delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return new Result("Check_list deleted", true);
        }
        return new Result("Check_list not found", false);
    }
}

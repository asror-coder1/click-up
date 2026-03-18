package asror_uz.service;

import asror_uz.dto.TaskDto;
import asror_uz.model.Result;
import asror_uz.model.Task;
import asror_uz.repository.CategoryRepo;
import asror_uz.repository.PriorityRepo;
import asror_uz.repository.StatusRepo;
import asror_uz.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepo repo;
    @Autowired
    StatusRepo statusRepo;
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    PriorityRepo priorityRepo;

    public Result create(TaskDto dto) {
        Task task = new Task();
        task.setName(dto.getName());
        task.setDescription(dto.getDescription());
        task.setStarted_date(dto.getStarted_date());
        task.setStart_time_has(dto.isStart_time_has());
        task.setDue_date(dto.getDue_date());
        task.setDue_time_has(dto.isDue_time_has());
        task.setEstimate_time(dto.getEstimate_time());
        task.setActived_date(dto.getActived_date());

        if (dto.getStatus_id() != null)
            statusRepo.findById(dto.getStatus_id()).ifPresent(task::setStatus);
        if (dto.getCategory_id() != null)
            categoryRepo.findById(dto.getCategory_id()).ifPresent(task::setCategory);
        if (dto.getPriority_id() != null)
            priorityRepo.findById(dto.getPriority_id()).ifPresent(task::setPriority);
        if (dto.getParent_task_id() != null)
            repo.findById(dto.getParent_task_id()).ifPresent(task::setParent_task);

        repo.save(task);
        return new Result("Task created", true);
    }

    public Task getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Task> getAll() {
        return repo.findAll();
    }

    public Result update(Long id, TaskDto dto) {
        Optional<Task> optional = repo.findById(id);
        if (optional.isPresent()) {
            Task task = optional.get();
            task.setName(dto.getName());
            task.setDescription(dto.getDescription());
            task.setStarted_date(dto.getStarted_date());
            task.setStart_time_has(dto.isStart_time_has());
            task.setDue_date(dto.getDue_date());
            task.setDue_time_has(dto.isDue_time_has());
            task.setEstimate_time(dto.getEstimate_time());
            task.setActived_date(dto.getActived_date());

            if (dto.getStatus_id() != null)
                statusRepo.findById(dto.getStatus_id()).ifPresent(task::setStatus);
            if (dto.getCategory_id() != null)
                categoryRepo.findById(dto.getCategory_id()).ifPresent(task::setCategory);
            if (dto.getPriority_id() != null)
                priorityRepo.findById(dto.getPriority_id()).ifPresent(task::setPriority);
            if (dto.getParent_task_id() != null)
                repo.findById(dto.getParent_task_id()).ifPresent(task::setParent_task);

            repo.save(task);
            return new Result("Task updated", true);
        }
        return new Result("Task not found", false);
    }

    public Result delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return new Result("Task deleted", true);
        }
        return new Result("Task not found", false);
    }
}

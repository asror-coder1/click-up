package asror_uz.service;

import asror_uz.dto.Task_dependencyDto;
import asror_uz.model.Result;
import asror_uz.model.Task_dependency;
import asror_uz.repository.TaskRepo;
import asror_uz.repository.Task_dependencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Task_dependencyService {

    @Autowired
    Task_dependencyRepo repo;
    @Autowired
    TaskRepo taskRepo;

    public Result create(Task_dependencyDto dto) {
        Task_dependency taskDependency = new Task_dependency();
        taskDependency.setDependency_type(dto.getDependency_type());

        if (dto.getTask_id() != null)
            taskRepo.findById(dto.getTask_id()).ifPresent(taskDependency::setTask);
        if (dto.getDependency_task_id() != null)
            taskRepo.findById(dto.getDependency_task_id()).ifPresent(taskDependency::setDependency_task);

        repo.save(taskDependency);
        return new Result("Task_dependency created", true);
    }

    public Task_dependency getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Task_dependency> getAll() {
        return repo.findAll();
    }

    public Result update(Long id, Task_dependencyDto dto) {
        Optional<Task_dependency> optional = repo.findById(id);
        if (optional.isPresent()) {
            Task_dependency taskDependency = optional.get();
            taskDependency.setDependency_type(dto.getDependency_type());

            if (dto.getTask_id() != null)
                taskRepo.findById(dto.getTask_id()).ifPresent(taskDependency::setTask);
            if (dto.getDependency_task_id() != null)
                taskRepo.findById(dto.getDependency_task_id()).ifPresent(taskDependency::setDependency_task);

            repo.save(taskDependency);
            return new Result("Task_dependency updated", true);
        }
        return new Result("Task_dependency not found", false);
    }

    public Result delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return new Result("Task_dependency deleted", true);
        }
        return new Result("Task_dependency not found", false);
    }
}

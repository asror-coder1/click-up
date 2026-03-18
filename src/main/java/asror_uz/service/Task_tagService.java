package asror_uz.service;

import asror_uz.dto.Task_tagDto;
import asror_uz.model.Result;
import asror_uz.model.Task_tag;
import asror_uz.repository.TagRepo;
import asror_uz.repository.TaskRepo;
import asror_uz.repository.Task_tagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Task_tagService {

    @Autowired
    Task_tagRepo repo;
    @Autowired
    TaskRepo taskRepo;
    @Autowired
    TagRepo tagRepo;

    public Result create(Task_tagDto dto) {
        Task_tag taskTag = new Task_tag();
        if (dto.getTask_id() != null)
            taskRepo.findById(dto.getTask_id()).ifPresent(taskTag::setTask);
        if (dto.getTag_id() != null)
            tagRepo.findById(dto.getTag_id()).ifPresent(taskTag::setTag);

        repo.save(taskTag);
        return new Result("Task_tag created", true);
    }

    public Task_tag getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Task_tag> getAll() {
        return repo.findAll();
    }

    public Result update(Long id, Task_tagDto dto) {
        Optional<Task_tag> optional = repo.findById(id);
        if (optional.isPresent()) {
            Task_tag taskTag = optional.get();
            if (dto.getTask_id() != null)
                taskRepo.findById(dto.getTask_id()).ifPresent(taskTag::setTask);
            if (dto.getTag_id() != null)
                tagRepo.findById(dto.getTag_id()).ifPresent(taskTag::setTag);

            repo.save(taskTag);
            return new Result("Task_tag updated", true);
        }
        return new Result("Task_tag not found", false);
    }

    public Result delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return new Result("Task_tag deleted", true);
        }
        return new Result("Task_tag not found", false);
    }
}

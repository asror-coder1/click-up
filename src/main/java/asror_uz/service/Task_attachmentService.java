package asror_uz.service;

import asror_uz.dto.Task_attachmentDto;
import asror_uz.model.Attachmet;
import asror_uz.model.Result;
import asror_uz.model.Task;
import asror_uz.model.Task_attachment;
import asror_uz.repository.AttachmetRepo;
import asror_uz.repository.TaskRepo;
import asror_uz.repository.Task_attachmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Task_attachmentService {

    @Autowired
    Task_attachmentRepo repo;
    @Autowired
    TaskRepo taskRepo;
    @Autowired
    AttachmetRepo attachmetRepo;

    public Result create(Task_attachmentDto dto) {
        Task_attachment taskAttachment = new Task_attachment();
        taskAttachment.setPin_cover_image(dto.isPin_cover_image());

        if (dto.getTask_id() != null)
            taskRepo.findById(dto.getTask_id()).ifPresent(taskAttachment::setTask);
        if (dto.getAttachment_id() != null)
            attachmetRepo.findById(dto.getAttachment_id()).ifPresent(taskAttachment::setAttachment);

        repo.save(taskAttachment);
        return new Result("Task_attachment created", true);
    }

    public Task_attachment getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Task_attachment> getAll() {
        return repo.findAll();
    }

    public Result update(Long id, Task_attachmentDto dto) {
        Optional<Task_attachment> optional = repo.findById(id);
        if (optional.isPresent()) {
            Task_attachment taskAttachment = optional.get();
            taskAttachment.setPin_cover_image(dto.isPin_cover_image());

            if (dto.getTask_id() != null)
                taskRepo.findById(dto.getTask_id()).ifPresent(taskAttachment::setTask);
            if (dto.getAttachment_id() != null)
                attachmetRepo.findById(dto.getAttachment_id()).ifPresent(taskAttachment::setAttachment);

            repo.save(taskAttachment);
            return new Result("Task_attachment updated", true);
        }
        return new Result("Task_attachment not found", false);
    }

    public Result delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return new Result("Task_attachment deleted", true);
        }
        return new Result("Task_attachment not found", false);
    }
}

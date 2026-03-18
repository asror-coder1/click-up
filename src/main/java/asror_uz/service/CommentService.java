package asror_uz.service;

import asror_uz.dto.CommentDto;
import asror_uz.model.Comment;
import asror_uz.model.Result;
import asror_uz.model.Task;
import asror_uz.repository.CommentRepo;
import asror_uz.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepo repo;
    @Autowired
    TaskRepo taskRepo;

    public Result create(CommentDto dto) {
        Comment comment = new Comment();
        comment.setName(dto.getName());
        if (dto.getTask_id() != null) {
            Optional<Task> taskOptional = taskRepo.findById(dto.getTask_id());
            taskOptional.ifPresent(comment::setTask);
        }
        repo.save(comment);
        return new Result("Comment created", true);
    }

    public Comment getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Comment> getAll() {
        return repo.findAll();
    }

    public Result update(Long id, CommentDto dto) {
        Optional<Comment> optional = repo.findById(id);
        if (optional.isPresent()) {
            Comment comment = optional.get();
            comment.setName(dto.getName());
            if (dto.getTask_id() != null) {
                Optional<Task> taskOptional = taskRepo.findById(dto.getTask_id());
                taskOptional.ifPresent(comment::setTask);
            }
            repo.save(comment);
            return new Result("Comment updated", true);
        }
        return new Result("Comment not found", false);
    }

    public Result delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return new Result("Comment deleted", true);
        }
        return new Result("Comment not found", false);
    }
}

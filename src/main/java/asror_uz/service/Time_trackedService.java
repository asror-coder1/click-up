package asror_uz.service;

import asror_uz.dto.Time_trackedDto;
import asror_uz.model.Result;
import asror_uz.model.Time_tracked;
import asror_uz.repository.TaskRepo;
import asror_uz.repository.Time_trackedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Time_trackedService {

    @Autowired
    Time_trackedRepo repo;
    @Autowired
    TaskRepo taskRepo;

    public Result create(Time_trackedDto dto) {
        Time_tracked timeTracked = new Time_tracked();
        timeTracked.setStarted_at(dto.getStarted_at());
        timeTracked.setStopped_at(dto.getStopped_at());

        if (dto.getTask_id() != null)
            taskRepo.findById(dto.getTask_id()).ifPresent(timeTracked::setTask);

        repo.save(timeTracked);
        return new Result("Time_tracked created", true);
    }

    public Time_tracked getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Time_tracked> getAll() {
        return repo.findAll();
    }

    public Result update(Long id, Time_trackedDto dto) {
        Optional<Time_tracked> optional = repo.findById(id);
        if (optional.isPresent()) {
            Time_tracked timeTracked = optional.get();
            timeTracked.setStarted_at(dto.getStarted_at());
            timeTracked.setStopped_at(dto.getStopped_at());

            if (dto.getTask_id() != null)
                taskRepo.findById(dto.getTask_id()).ifPresent(timeTracked::setTask);

            repo.save(timeTracked);
            return new Result("Time_tracked updated", true);
        }
        return new Result("Time_tracked not found", false);
    }

    public Result delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return new Result("Time_tracked deleted", true);
        }
        return new Result("Time_tracked not found", false);
    }
}

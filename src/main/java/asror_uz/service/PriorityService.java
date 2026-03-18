package asror_uz.service;

import asror_uz.dto.PriorityDto;
import asror_uz.model.Icon;
import asror_uz.model.Priority;
import asror_uz.model.Result;
import asror_uz.repository.IconRepo;
import asror_uz.repository.PriorityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriorityService {

    @Autowired
    PriorityRepo repo;
    @Autowired
    IconRepo iconRepo;

    public Result create(PriorityDto dto) {
        Priority priority = new Priority();
        priority.setName(dto.getName());
        if (dto.getIcon_id() != null) {
            Optional<Icon> iconOptional = iconRepo.findById(dto.getIcon_id());
            iconOptional.ifPresent(priority::setIcon);
        }
        repo.save(priority);
        return new Result("Priority created", true);
    }

    public Priority getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Priority> getAll() {
        return repo.findAll();
    }

    public Result update(Long id, PriorityDto dto) {
        Optional<Priority> optional = repo.findById(id);
        if (optional.isPresent()) {
            Priority priority = optional.get();
            priority.setName(dto.getName());
            if (dto.getIcon_id() != null) {
                Optional<Icon> iconOptional = iconRepo.findById(dto.getIcon_id());
                iconOptional.ifPresent(priority::setIcon);
            }
            repo.save(priority);
            return new Result("Priority updated", true);
        }
        return new Result("Priority not found", false);
    }

    public Result delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return new Result("Priority deleted", true);
        }
        return new Result("Priority not found", false);
    }
}

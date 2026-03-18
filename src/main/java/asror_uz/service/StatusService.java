package asror_uz.service;

import asror_uz.dto.StatusDto;
import asror_uz.model.Result;
import asror_uz.model.Status;
import asror_uz.repository.CategoryRepo;
import asror_uz.repository.ProjectRepo;
import asror_uz.repository.SpaceRepo;
import asror_uz.repository.StatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    @Autowired
    StatusRepo repo;
    @Autowired
    SpaceRepo spaceRepo;
    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    CategoryRepo categoryRepo;

    public Result create(StatusDto dto) {
        Status status = new Status();
        status.setName(dto.getName());
        status.setColor(dto.getColor());
        status.setType(dto.getType());

        if (dto.getSpace_id() != null) {
            spaceRepo.findById(dto.getSpace_id()).ifPresent(status::setSpace);
        }
        if (dto.getProject_id() != null) {
            projectRepo.findById(dto.getProject_id()).ifPresent(status::setProject);
        }
        if (dto.getCategory_id() != null) {
            categoryRepo.findById(dto.getCategory_id()).ifPresent(status::setCategory);
        }

        repo.save(status);
        return new Result("Status created", true);
    }

    public Status getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Status> getAll() {
        return repo.findAll();
    }

    public Result update(Long id, StatusDto dto) {
        Optional<Status> optional = repo.findById(id);
        if (optional.isPresent()) {
            Status status = optional.get();
            status.setName(dto.getName());
            status.setColor(dto.getColor());
            status.setType(dto.getType());

            if (dto.getSpace_id() != null) {
                spaceRepo.findById(dto.getSpace_id()).ifPresent(status::setSpace);
            }
            if (dto.getProject_id() != null) {
                projectRepo.findById(dto.getProject_id()).ifPresent(status::setProject);
            }
            if (dto.getCategory_id() != null) {
                categoryRepo.findById(dto.getCategory_id()).ifPresent(status::setCategory);
            }

            repo.save(status);
            return new Result("Status updated", true);
        }
        return new Result("Status not found", false);
    }

    public Result delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return new Result("Status deleted", true);
        }
        return new Result("Status not found", false);
    }
}

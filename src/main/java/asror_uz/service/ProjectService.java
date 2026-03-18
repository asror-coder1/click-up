package asror_uz.service;

import asror_uz.dto.ProjectDto;
import asror_uz.model.Project;
import asror_uz.model.Result;
import asror_uz.model.Space;
import asror_uz.repository.ProjectRepo;
import asror_uz.repository.SpaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepo repo;

    @Autowired
    SpaceRepo spaceRepo;

    public Result create(ProjectDto dto) {
        Project project = new Project();
        project.setName(dto.getName());
        project.setAccess_type(dto.getAccess_type());
        project.setArchived(dto.isArchived());
        project.setColor(dto.getColor());

        Optional<Space> optionalSpace = spaceRepo.findById(dto.getSpace_id());
        if(optionalSpace.isPresent()){
            project.setSpace(optionalSpace.get());
        }

        repo.save(project);
        return new Result("Project created", true);
    }

    public Project getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Project> getAll() {
        return repo.findAll();
    }

    public Result update(Long id, ProjectDto dto) {
        Optional<Project> optional = repo.findById(id);
        if (optional.isPresent()) {
            Project project = optional.get();
            project.setName(dto.getName());
            project.setAccess_type(dto.getAccess_type());
            project.setArchived(dto.isArchived());
            project.setColor(dto.getColor());

            Optional<Space> optionalSpace = spaceRepo.findById(dto.getSpace_id());
            if(optionalSpace.isPresent()){
                project.setSpace(optionalSpace.get());
            }

            repo.save(project);
            return new Result("Project updated", true);
        }
        return new Result("Project not found", false);
    }

    public Result delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return new Result("Project deleted", true);
        }
        return new Result("Project not found", false);
    }
}

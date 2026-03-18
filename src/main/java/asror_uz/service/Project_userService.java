package asror_uz.service;

import asror_uz.dto.Project_userDto;
import asror_uz.model.Project_user;
import asror_uz.model.Result;
import asror_uz.repository.ProjectRepo;
import asror_uz.repository.Project_userRepo;
import asror_uz.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Project_userService {

    @Autowired
    Project_userRepo repo;
    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    UserRepo userRepo;

    public Result create(Project_userDto dto) {
        Project_user projectUser = new Project_user();
        projectUser.setTask_permission(dto.getTask_permission());

        if (dto.getProject_id() != null)
            projectRepo.findById(dto.getProject_id()).ifPresent(projectUser::setProject);
        if (dto.getUser_id() != null)
            userRepo.findById(dto.getUser_id()).ifPresent(projectUser::setUser);

        repo.save(projectUser);
        return new Result("Project_user created", true);
    }

    public Project_user getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Project_user> getAll() {
        return repo.findAll();
    }

    public Result update(Long id, Project_userDto dto) {
        Optional<Project_user> optional = repo.findById(id);
        if (optional.isPresent()) {
            Project_user projectUser = optional.get();
            projectUser.setTask_permission(dto.getTask_permission());

            if (dto.getProject_id() != null)
                projectRepo.findById(dto.getProject_id()).ifPresent(projectUser::setProject);
            if (dto.getUser_id() != null)
                userRepo.findById(dto.getUser_id()).ifPresent(projectUser::setUser);

            repo.save(projectUser);
            return new Result("Project_user updated", true);
        }
        return new Result("Project_user not found", false);
    }

    public Result delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return new Result("Project_user deleted", true);
        }
        return new Result("Project_user not found", false);
    }
}

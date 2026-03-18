package asror_uz.service;

import asror_uz.dto.CategoryDto;
import asror_uz.model.Category;
import asror_uz.model.Project;
import asror_uz.model.Result;
import asror_uz.repository.CategoryRepo;
import asror_uz.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo repo;

    @Autowired
    ProjectRepo projectRepo;

    public Result create(CategoryDto dto) {
        Category category = new Category();
        category.setName(dto.getName());
        category.setAccess_type(dto.getAccess_type());
        category.setArchived(dto.isArchived());
        category.setColor(dto.getColor());

        Optional<Project> optionalProject = projectRepo.findById(dto.getProject_id());
        if(optionalProject.isPresent()){
            category.setProject(optionalProject.get());
        }

        repo.save(category);
        return new Result("Category created", true);
    }

    public Category getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Category> getAll() {
        return repo.findAll();
    }

    public Result update(Long id, CategoryDto dto) {
        Optional<Category> optional = repo.findById(id);
        if (optional.isPresent()) {
            Category category = optional.get();
            category.setName(dto.getName());
            category.setAccess_type(dto.getAccess_type());
            category.setArchived(dto.isArchived());
            category.setColor(dto.getColor());

            Optional<Project> optionalProject = projectRepo.findById(dto.getProject_id());
            if(optionalProject.isPresent()){
                category.setProject(optionalProject.get());
            }

            repo.save(category);
            return new Result("Category updated", true);
        }
        return new Result("Category not found", false);
    }

    public Result delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return new Result("Category deleted", true);
        }
        return new Result("Category not found", false);
    }
}

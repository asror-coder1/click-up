package asror_uz.service;

import asror_uz.dto.Category_userDto;
import asror_uz.model.Category_user;
import asror_uz.model.Result;
import asror_uz.repository.CategoryRepo;
import asror_uz.repository.Category_userRepo;
import asror_uz.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Category_userService {

    @Autowired
    Category_userRepo repo;
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    UserRepo userRepo;

    public Result create(Category_userDto dto) {
        Category_user categoryUser = new Category_user();
        categoryUser.setName(dto.getName());
        categoryUser.setTask_permission(dto.getTask_permission());

        if (dto.getCategory_id() != null)
            categoryRepo.findById(dto.getCategory_id()).ifPresent(categoryUser::setCategory);
        if (dto.getUser_id() != null)
            userRepo.findById(dto.getUser_id()).ifPresent(categoryUser::setUser);

        repo.save(categoryUser);
        return new Result("Category_user created", true);
    }

    public Category_user getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Category_user> getAll() {
        return repo.findAll();
    }

    public Result update(Long id, Category_userDto dto) {
        Optional<Category_user> optional = repo.findById(id);
        if (optional.isPresent()) {
            Category_user categoryUser = optional.get();
            categoryUser.setName(dto.getName());
            categoryUser.setTask_permission(dto.getTask_permission());

            if (dto.getCategory_id() != null)
                categoryRepo.findById(dto.getCategory_id()).ifPresent(categoryUser::setCategory);
            if (dto.getUser_id() != null)
                userRepo.findById(dto.getUser_id()).ifPresent(categoryUser::setUser);

            repo.save(categoryUser);
            return new Result("Category_user updated", true);
        }
        return new Result("Category_user not found", false);
    }

    public Result delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return new Result("Category_user deleted", true);
        }
        return new Result("Category_user not found", false);
    }
}

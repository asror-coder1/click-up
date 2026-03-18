package asror_uz.service;

import asror_uz.dto.UserDto;
import asror_uz.model.Result;
import asror_uz.model.User;
import asror_uz.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo repo;

    // CREATE
    public Result create(UserDto dto){

        if(repo.existsByEmail(dto.getEmail())){
            return new Result("Email already exists", false);
        }

        User user = new User();
        user.setFull_name(dto.getFull_name());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setColor(dto.getColor());
        user.setInitial_letter(dto.getInitial_letter());
        user.setAvatar_id(dto.getAvatar_id());

        repo.save(user);

        return new Result("User created", true);
    }

    // GET ALL
    public List<User> getAll(){
        return repo.findAll();
    }

    // GET BY ID
    public User getById(Long id){
        Optional<User> optionalUser = repo.findById(id);
        return optionalUser.orElse(null);
    }

    // UPDATE
    public Result update(Long id, UserDto dto){

        Optional<User> optionalUser = repo.findById(id);

        if(optionalUser.isPresent()){
            return new Result("User not found", false);
        }

        User user = optionalUser.get();

        user.setFull_name(dto.getFull_name());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setColor(dto.getColor());
        user.setInitial_letter(dto.getInitial_letter());
        user.setAvatar_id(dto.getAvatar_id());

        repo.save(user);

        return new Result("User updated", true);
    }

    // DELETE
    public Result delete(Long id){

        Optional<User> optionalUser = repo.findById(id);

        if(optionalUser.isEmpty()){
            return new Result("User not found", false);
        }
        repo.deleteById(id);
        return new Result("User deleted", true);
    }

}
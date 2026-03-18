package asror_uz.service;

import asror_uz.dto.Space_userDto;
import asror_uz.model.Result;
import asror_uz.model.Space_user;
import asror_uz.repository.Space_userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Space_userService {
    @Autowired
    Space_userRepo repo;

    public Result create(Space_userDto dto){
        Space_user spaceUser = new Space_user();
        spaceUser.setSpace_id(dto.getSpace_id());
        spaceUser.setMember_id(dto.getMember_id());

        repo.save(spaceUser);
        return new Result("Saqlandi" , true);
    }

    public Space_user getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Space_user> getAll() {
        return repo.findAll();
    }

    public Result update(Long id, Space_userDto dto) {
        Optional<Space_user> optional = repo.findById(id);
        if (optional.isPresent()) {
            Space_user spaceUser = optional.get();
            spaceUser.setSpace_id(dto.getSpace_id());
            spaceUser.setMember_id(dto.getMember_id());

            repo.save(spaceUser);
            return new Result("Updated", true);
        }
        return new Result("Id topilmadi", false);
    }

    public Result delete(Long id){
        Optional<Space_user> optional = repo.findById(id);
        if (optional.isPresent()){
            repo.findById(id);
            return new Result("Deleted" , true);
        }
        return new Result("Id topilmadi", false);
    }
}

package asror_uz.service;

import asror_uz.dto.SpaceDto;
import asror_uz.model.Result;
import asror_uz.model.Space;
import asror_uz.repository.SpaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceService {
    @Autowired
    SpaceRepo repo;

//    CRUD

    public Result create(SpaceDto dto){
        boolean byName = repo.existsByName(dto.getName());
        if (byName) {
            return new Result("BUnday name mavjud", false);
        }
        Space space = new Space();
        space.setName(dto.getName());
        space.setColor(dto.getColor());
        space.setWorkspace_id(dto.getWorkspace_id());
        space.setInitial_letter(dto.getInitial_letter());
        space.setIcon_id(dto.getIcon_id());
        space.setAvatar_id(dto.getAvatar_id());
        space.setOwner_id(dto.getOwner_id());
        space.setAccess_type(dto.getAccess_type());

        repo.save(space);
        return new Result("Saqlandi" , true);
    }

//    Read

    public Space getById(Long id){
        Optional<Space> byId = repo.findById(id);
        return byId.orElse(null);
    }

//    Read all

    public List<Space> getAll(){
        return repo.findAll();
    }

//    Update

    public Result update(Long id , SpaceDto dto){
        Optional<Space> optional = repo.findById(id);
        if (optional.isPresent()){
            Space space = optional.get();
            space.setName(dto.getName());
            space.setColor(dto.getColor());
            space.setWorkspace_id(dto.getWorkspace_id());
            space.setInitial_letter(dto.getInitial_letter());
            space.setIcon_id(dto.getIcon_id());
            space.setAvatar_id(dto.getAvatar_id());
            space.setOwner_id(dto.getOwner_id());
            space.setAccess_type(dto.getAccess_type());

            repo.save(space);

            return new Result("Update boldi" , true);
        }
        return new Result("Id topilmadi" , false);
    }

//    Delete

    public Result delete(Long id){
        Optional<Space> optional = repo.findById(id);
        if (optional.isPresent()){
            Space space = optional.get();
            repo.delete(space);
            return new Result("Delete boldi" , true);
        }
        return new Result("Bunday id topilmadi" ,false);
    }
}

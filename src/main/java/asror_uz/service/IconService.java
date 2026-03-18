package asror_uz.service;

import asror_uz.dto.IconDto;
import asror_uz.model.Icon;
import asror_uz.model.Result;
import asror_uz.repository.IconRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IconService {
    @Autowired
    IconRepo repo;

//    CRUD

//    Create
    public Result create(IconDto dto) {
        Icon icon = new Icon();
        icon.setAttachment_id(dto.getAttachment_id());
        icon.setColor(dto.getColor());
        icon.setColor(dto.getColor());
        icon.setInitial_letter(dto.getInitial_letter());
        icon.setIcon(dto.getIcon());

        repo.save(icon);
        return new Result("Saqlandi" , true);
    }

//    Read BYID

    public Icon getById(Long id){
        Optional<Icon> byId = repo.findById(id);
        return  byId.orElse(null);
    }

//    Read all

    public List<Icon> getAll(){
        return repo.findAll();
    }

//    Update

    public Result update(Long id , IconDto dto){
        Optional<Icon> optional = repo.findById(id);
        if (optional.isPresent()){
            Icon icon = optional.get();

            icon.setAttachment_id(dto.getAttachment_id());
            icon.setColor(dto.getColor());
            icon.setColor(dto.getColor());
            icon.setInitial_letter(dto.getInitial_letter());
            icon.setIcon(dto.getIcon());

            repo.save(icon);
            return new Result("Update boldi" , true);
        }
        return new Result("Id tpilmaidi" , false);
    }

//    Delete

    public Result delete (Long id){
        repo.deleteById(id);
        return new Result("Delete boldi" , true);
    }

}

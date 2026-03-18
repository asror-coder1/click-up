package asror_uz.service;

import asror_uz.dto.AttachmetDto;
import asror_uz.model.Attachmet;
import asror_uz.model.Result;
import asror_uz.repository.AttachmetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttachmetService {

    @Autowired
    AttachmetRepo repo;

//    Create

    public Result create(AttachmetDto dto){
        Attachmet attachmet = new Attachmet();
        attachmet.setName(dto.getName());
        attachmet.setOriginal_name(dto.getOriginal_name());
        attachmet.setSize(dto.getSize());
        attachmet.setContent_type(dto.getContent_type());

        repo.save(attachmet);
        return new Result("Saqlandi" , true);
    }

//    Read Byid

    public Attachmet byid(Long id){
        Optional<Attachmet> byId = repo.findById(id);
        return byId.orElse(null);
    }

    public List<Attachmet> getAll(){
        List<Attachmet> all = repo.findAll();
        return all;
    }

//    Update

    public Result update(Long id , AttachmetDto dto){
        Optional<Attachmet> optional = repo.findById(id);

        if (optional.isPresent()){
            Attachmet attachmet = optional.get();
            attachmet.setName(dto.getName());
            attachmet.setOriginal_name(dto.getOriginal_name());
            attachmet.setSize(dto.getSize());
            attachmet.setContent_type(dto.getContent_type());

            repo.save(attachmet);

            return new Result("Update boldi" , true);
        }
        return new Result("Id topilmadi" , false);
    }

//    Delete

    public Result delete(Long id){
        repo.deleteById(id);
        return new Result("Delete boldi" , true);
    }

}

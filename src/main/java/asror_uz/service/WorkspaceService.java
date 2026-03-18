package asror_uz.service;

import asror_uz.dto.WorkspaceDto;
import asror_uz.model.Result;
import asror_uz.model.Workspace;
import asror_uz.repository.WorkspaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkspaceService {
    @Autowired
    WorkspaceRepo repo;

//    CRUD

//    1- create

    public Result create(WorkspaceDto dto){

        boolean existsByName = repo.existsByName(dto.getName());
        if(existsByName){
            return new Result("Bunday name mavjud emas" , false);
        }
        Workspace workspace = new Workspace();
        workspace.setName(dto.getName());
        workspace.setColor(dto.getColor());
        workspace.setOwner_id(dto.getOwner_id());
        workspace.setInitial_letter(dto.getInitial_letter());
        workspace.setAvatar_id(dto.getAvatar_id());
        repo.save(workspace);

        return new Result("Saqlandi" , true);
    }

//    2 - Get byId

    public Workspace getById(Long id){
        Optional<Workspace> byId = repo.findById(id);
        return byId.orElse(null);
    }

//    3 - All

    public List<Workspace> getAll(){
        return repo.findAll();
    }

//    Update

    public Result update(Long id , WorkspaceDto dto){
        Optional<Workspace> optional = repo.findById(id);

        if (optional.isPresent()){
            Workspace workspace = optional.get();
            workspace.setName(dto.getName());
            workspace.setColor(dto.getColor());
            workspace.setOwner_id(dto.getOwner_id());
            workspace.setInitial_letter(dto.getInitial_letter());
            workspace.setAvatar_id(dto.getAvatar_id());
            repo.save(workspace);
            return new Result("Update" , true);
        }
        return new Result("Id topilmadi", false);
    }

//    Delete

    public Result delete (Long id){
        Optional<Workspace> byId = repo.findById(id);
        if (byId.isPresent()){
            Workspace workspace = byId.get();
            repo.delete(workspace);
            return new Result("Delete boldi" , true);
        }
        return new Result("Id topilmadi" , false);
    }
}

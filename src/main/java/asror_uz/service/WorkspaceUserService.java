package asror_uz.service;

import asror_uz.dto.WorkspaceUserDto;
import asror_uz.model.Result;
import asror_uz.model.WorkspaceUser;
import asror_uz.repository.WorkspaceUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkspaceUserService {
   @Autowired
    WorkspaceUserRepo repo;

//   CRUD

//    create

    public Result create(WorkspaceUserDto dto){
        WorkspaceUser workspaceUser = new WorkspaceUser();
        workspaceUser.setWorkspace_id(dto.getWorkspace_id());
        workspaceUser.setUser_id(dto.getUser_id());
        workspaceUser.setWorkspace_role_id(dto.getWorkspace_role_id());
        workspaceUser.setDate_invited(dto.getDate_invited());
        workspaceUser.setDate_joined(dto.getDate_joined());

        repo.save(workspaceUser);

        return new Result("Saqlandi" , true);
    }

//    Read byId

    public WorkspaceUser readById(Long id){
        Optional<WorkspaceUser> byId = repo.findById(id);
        return byId.orElse(null);
    }

//    Read all

    public List<WorkspaceUser> getAll(){
        List<WorkspaceUser> all = repo.findAll();
        return all;
    }

//    Update

    public Result update(Long id , WorkspaceUserDto dto){
        Optional<WorkspaceUser> optional = repo.findById(id);
        if (optional.isPresent()){
            WorkspaceUser workspaceUser = optional.get();
            workspaceUser.setWorkspace_id(dto.getWorkspace_id());
            workspaceUser.setUser_id(dto.getUser_id());
            workspaceUser.setWorkspace_role_id(dto.getWorkspace_role_id());
            workspaceUser.setDate_invited(dto.getDate_invited());
            workspaceUser.setDate_joined(dto.getDate_joined());

            return new Result("Update boldi" , true);
        }
        return new Result("Id toppilmadi" , false);
    }

//    Delete

    public Result delete (Long id){
        repo.deleteById(id);
        return new Result("Delete boldi" , true);
    }
}

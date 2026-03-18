package asror_uz.service;

import asror_uz.dto.Workspace_permissionDto;
import asror_uz.model.Result;
import asror_uz.model.Workspace_permission;
import asror_uz.repository.Workspace_permissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Workspace_permissionService {
    @Autowired
    Workspace_permissionRepo repo;

//    CRUD

//    create

    public Result create(Workspace_permissionDto dto){
        Workspace_permission workspacePermission = new Workspace_permission();
        workspacePermission.setWorkspace_role_id(dto.getWorkspace_role_id());
        workspacePermission.setPermission_enum(dto.getPermission_enum());

        repo.save(workspacePermission);
        return new Result("Saqlandi" , true);
    }

    public Workspace_permission getById(Long id){
        Optional<Workspace_permission> byId = repo.findById(id);
        return byId.orElse(null);
    }

    public List<Workspace_permission> getAll(){
        return repo.findAll();
    }

    public Result update(Long id , Workspace_permissionDto dto){
        Optional<Workspace_permission> optional = repo.findById(id);
        if (optional.isPresent()){
            Workspace_permission workspacePermission = optional.get();

            workspacePermission.setWorkspace_role_id(dto.getWorkspace_role_id());
            workspacePermission.setPermission_enum(dto.getPermission_enum());

            repo.save(workspacePermission);
            return new Result("Saqlandi" , true);
        }
        return new Result("Id topilmadi" , false);
    }

//    Delete

    public Result delete(Long id){
        Optional<Workspace_permission> optional = repo.findById(id);
        if (optional.isPresent()){
            repo.deleteById(id);
            return new Result("Deleted" , true);
        }
        return new Result("Id topilmadi" ,false);
    }
}

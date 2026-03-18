package asror_uz.service;

import asror_uz.dto.WorkspaceRoleDto;
import asror_uz.model.Result;
import asror_uz.model.WorkspaceRole;
import asror_uz.repository.WorkspaceRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkspaceRoleService {
    @Autowired
    WorkspaceRoleRepo repo;

//    CRUD

    public Result create(WorkspaceRoleDto dto){
        WorkspaceRole workspaceRole = new WorkspaceRole();
        workspaceRole.setWorkspace_id(dto.getWorkspace_id());
        workspaceRole.setName(dto.getName());
        workspaceRole.setExtends_role(dto.getExtends_role());

        repo.save(workspaceRole);

        return new Result("Saqlandi" , true);
    }

    public WorkspaceRole getbyId(Long id){
        Optional<WorkspaceRole> byId = repo.findById(id);
        return byId.orElse(null);
    }

    public List<WorkspaceRole> getAll(){
        List<WorkspaceRole> all = repo.findAll();
        return all;
    }

    public Result update(Long id , WorkspaceRoleDto dto){
        Optional<WorkspaceRole> optional = repo.findById(id);
        if (optional.isPresent()){
            WorkspaceRole workspaceRole = optional.get();
            workspaceRole.setWorkspace_id(dto.getWorkspace_id());
            workspaceRole.setName(dto.getName());
            workspaceRole.setExtends_role(dto.getExtends_role());

            repo.save(workspaceRole);

            return new Result("Update boldi" , true);
        }
        return new Result("Id topilmaid" , false);
    }

    public Result delete(Long id){
        repo.deleteById(id);
        return new Result("Delete boldi" , true);
    }
}

package asror_uz.service;

import asror_uz.dto.Space_click_appsDto;
import asror_uz.model.Result;
import asror_uz.model.Space_click_apps;
import asror_uz.repository.Space_click_appsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Space_click_appsService {

    @Autowired
    Space_click_appsRepo repo;

    public Result create(Space_click_appsDto dto){
        Space_click_apps spaceClickApps = new Space_click_apps();
        spaceClickApps.setSpace_id(dto.getSpace_id());
        spaceClickApps.setClick_apps_id(dto.getClick_apps_id());

        repo.save(spaceClickApps);
        return new Result("Saqlandi" , true);
    }

    public Space_click_apps getById(Long id){
        Optional<Space_click_apps> byId = repo.findById(id);
        return byId.orElse(null);
    }

    public List<Space_click_apps> getAll(){
        List<Space_click_apps> all = repo.findAll();
        return all;
    }

    public Result update(Long id , Space_click_appsDto dto){
        Optional<Space_click_apps> optional = repo.findById(id);
        if (optional.isPresent()){
            Space_click_apps spaceClickApps = optional.get();

            spaceClickApps.setSpace_id(dto.getSpace_id());
            spaceClickApps.setClick_apps_id(dto.getClick_apps_id());

            repo.save(spaceClickApps);
            return new Result("Updated" , true);
        }
        return new Result("Id topilmadi" , false);
    }

    public Result delete(Long id){
        Optional<Space_click_apps> byId = repo.findById(id);
        if (byId.isPresent()){
            repo.deleteById(id);

            return new Result("Deleted" , true);
        }
        return new Result("Id not found" ,false);
    }

}

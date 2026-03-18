package asror_uz.service;

import asror_uz.dto.Click_appsDto;
import asror_uz.model.Click_apps;
import asror_uz.model.Result;
import asror_uz.repository.Click_appsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClickApps_service {

    @Autowired
    Click_appsRepo repo;

    public Result create(Click_appsDto dto){
        Click_apps clickApps = new Click_apps();
        clickApps.setName(dto.getName());
        clickApps.setIcon_id(dto.getIcon_id());

        repo.save(clickApps);
        return new Result("Saqlandi" , true);
    }

//    Get id

    public Click_apps getById(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Click_apps with id " + id + " not found"));
    }

//    Get All

    public List<Click_apps> getAll(){
        return repo.findAll();
    }

//    update

    public Result update(Long id , Click_appsDto dto){
        Optional<Click_apps> optional = repo.findById(id);
        if (optional.isPresent()){
            Click_apps clickApps = optional.get();
            clickApps.setName(dto.getName());
            clickApps.setIcon_id(dto.getIcon_id());

            repo.save(clickApps);
            return new Result("Updated" , true);
        }
        return new Result("Id topilmadi" , false);
    }

//    Deleted

    public Result delete(Long id){
        Optional<Click_apps> optional = repo.findById(id);
        if (optional.isPresent()){
            repo.deleteById(id);
            return new Result("deleted" , true);
        }
        return new Result("Id topilmadi" , false);
    }
}

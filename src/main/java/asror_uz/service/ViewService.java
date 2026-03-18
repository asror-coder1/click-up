package asror_uz.service;

import asror_uz.dto.ViewDto;
import asror_uz.model.Result;
import asror_uz.model.VIew;
import asror_uz.repository.ViewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViewService {

    @Autowired
    ViewRepo repo;

    // CREATE
    public Result create(ViewDto dto){
        VIew view = new VIew();
        view.setName(dto.getName());
        view.setIcon_id(dto.getIcon_id());

        repo.save(view);
        return new Result("Saqlandi", true);
    }

    // GET ALL
    public List<VIew> getAll(){
        return repo.findAll();
    }

    // GET BY ID
    public VIew getById(Long id){
        Optional<VIew> optionalView = repo.findById(id);
        return optionalView.orElse(null);
    }

    // UPDATE
    public Result update(Long id, ViewDto dto){
        Optional<VIew> optionalView = repo.findById(id);

        if(optionalView.isPresent()){
            VIew view = optionalView.get();
            view.setName(dto.getName());
            view.setIcon_id(dto.getIcon_id());

            repo.save(view);
            return new Result("Yangilandi", true);
        }

        return new Result("ID Topilmadi", false);
    }

    // DELETE
    public Result delete(Long id){
        Optional<VIew> optionalView = repo.findById(id);

        if(optionalView.isPresent()){
            repo.deleteById(id);
            return new Result("O'chirildi", true);
        }

        return new Result("ID Topilmadi", false);
    }
}
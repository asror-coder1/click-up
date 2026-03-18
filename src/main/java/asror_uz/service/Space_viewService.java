package asror_uz.service;

import asror_uz.dto.Space_viewDto;
import asror_uz.model.Result;
import asror_uz.model.Space;
import asror_uz.model.Space_view;
import asror_uz.model.VIew;
import asror_uz.repository.SpaceRepo;
import asror_uz.repository.Space_viewRepo;
import asror_uz.repository.ViewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Space_viewService {

    @Autowired
    Space_viewRepo repo;

    @Autowired
    SpaceRepo spaceRepo;

    @Autowired
    ViewRepo viewRepo;

    public Result create(Space_viewDto dto) {
        Optional<Space> spaceOptional = spaceRepo.findById(dto.getSpace_id());
        Optional<VIew> viewOptional = viewRepo.findById(dto.getView_id());

        if (spaceOptional.isPresent() && viewOptional.isPresent()) {
            Space_view spaceView = new Space_view();
            spaceView.setSpace(spaceOptional.get());
            spaceView.setView(viewOptional.get());
            repo.save(spaceView);
            return new Result("Saved", true);
        }
        return new Result("Space or View not found", false);
    }

    public Space_view getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Space_view> getAll() {
        return repo.findAll();
    }

    public Result update(Long id, Space_viewDto dto) {
        Optional<Space_view> optional = repo.findById(id);
        if (optional.isPresent()) {
            Optional<Space> spaceOptional = spaceRepo.findById(dto.getSpace_id());
            Optional<VIew> viewOptional = viewRepo.findById(dto.getView_id());

            if (spaceOptional.isPresent() && viewOptional.isPresent()) {
                Space_view spaceView = optional.get();
                spaceView.setSpace(spaceOptional.get());
                spaceView.setView(viewOptional.get());
                repo.save(spaceView);
                return new Result("Updated", true);
            }
            return new Result("Space or View not found", false);
        }
        return new Result("Id not found", false);
    }

    public Result delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return new Result("Deleted", true);
        }
        return new Result("Id not found", false);
    }
}

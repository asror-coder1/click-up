package asror_uz.service;

import asror_uz.dto.Check_list_itemDto;
import asror_uz.model.Check_list_item;
import asror_uz.model.Result;
import asror_uz.repository.Check_listRepo;
import asror_uz.repository.Check_list_itemRepo;
import asror_uz.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Check_list_itemService {

    @Autowired
    Check_list_itemRepo repo;
    @Autowired
    Check_listRepo checkListRepo;
    @Autowired
    UserRepo userRepo;

    public Result create(Check_list_itemDto dto) {
        Check_list_item item = new Check_list_item();
        item.setName(dto.getName());
        item.setResolved(dto.isResolved());

        if (dto.getCheck_list_id() != null)
            checkListRepo.findById(dto.getCheck_list_id()).ifPresent(item::setCheck_list);
        if (dto.getAssigned_user_id() != null)
            userRepo.findById(dto.getAssigned_user_id()).ifPresent(item::setAssigned_user);

        repo.save(item);
        return new Result("Check_list_item created", true);
    }

    public Check_list_item getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Check_list_item> getAll() {
        return repo.findAll();
    }

    public Result update(Long id, Check_list_itemDto dto) {
        Optional<Check_list_item> optional = repo.findById(id);
        if (optional.isPresent()) {
            Check_list_item item = optional.get();
            item.setName(dto.getName());
            item.setResolved(dto.isResolved());

            if (dto.getCheck_list_id() != null)
                checkListRepo.findById(dto.getCheck_list_id()).ifPresent(item::setCheck_list);
            if (dto.getAssigned_user_id() != null)
                userRepo.findById(dto.getAssigned_user_id()).ifPresent(item::setAssigned_user);

            repo.save(item);
            return new Result("Check_list_item updated", true);
        }
        return new Result("Check_list_item not found", false);
    }

    public Result delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return new Result("Check_list_item deleted", true);
        }
        return new Result("Check_list_item not found", false);
    }
}

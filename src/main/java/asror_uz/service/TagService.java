package asror_uz.service;

import asror_uz.dto.TagDto;
import asror_uz.model.Result;
import asror_uz.model.Tag;
import asror_uz.repository.TagRepo;
import asror_uz.repository.WorkspaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    TagRepo repo;
    @Autowired
    WorkspaceRepo workspaceRepo;

    public Result create(TagDto dto) {
        Tag tag = new Tag();
        tag.setName(dto.getName());
        tag.setColor(dto.getColor());
        if (dto.getWorkspace_id() != null)
            workspaceRepo.findById(dto.getWorkspace_id()).ifPresent(tag::setWorkspace);

        repo.save(tag);
        return new Result("Tag created", true);
    }

    public Tag getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Tag> getAll() {
        return repo.findAll();
    }

    public Result update(Long id, TagDto dto) {
        Optional<Tag> optional = repo.findById(id);
        if (optional.isPresent()) {
            Tag tag = optional.get();
            tag.setName(dto.getName());
            tag.setColor(dto.getColor());
            if (dto.getWorkspace_id() != null)
                workspaceRepo.findById(dto.getWorkspace_id()).ifPresent(tag::setWorkspace);

            repo.save(tag);
            return new Result("Tag updated", true);
        }
        return new Result("Tag not found", false);
    }

    public Result delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return new Result("Tag deleted", true);
        }
        return new Result("Tag not found", false);
    }
}

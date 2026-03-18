package asror_uz.repository;

import asror_uz.model.Workspace_permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Workspace_permissionRepo extends JpaRepository<Workspace_permission, Long> {
    void findAllById(Long id);
}
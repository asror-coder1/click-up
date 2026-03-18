package asror_uz.repository;

import asror_uz.model.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceRepo extends JpaRepository<Workspace , Long> {
    boolean existsByName(String name);
}

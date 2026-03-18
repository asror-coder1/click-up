package asror_uz.repository;

import asror_uz.model.Workspace;
import asror_uz.model.WorkspaceRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceRoleRepo extends JpaRepository<WorkspaceRole, Long> {
}

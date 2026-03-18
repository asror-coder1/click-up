package asror_uz.repository;

import asror_uz.model.Space;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceRepo extends JpaRepository<Space , Long> {
    boolean existsByName(String name);
}

package filmapi.Repositories;

import filmapi.Classes.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectorRepository extends JpaRepository<Director, Long> {
    List<Director> findByNameLike (String name);
}

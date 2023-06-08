package filmapi.Repositories;

import filmapi.Classes.Category;
import filmapi.Classes.MovieCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieCategoryRepository extends JpaRepository<MovieCategory,Long> {
    List<MovieCategory> findByCategory (Category category);
}

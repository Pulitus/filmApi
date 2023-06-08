package filmapi.Repositories;

import filmapi.Classes.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {
    List<Movie> findByTitleLike (String title);
    List<Movie> findByReleaseYear(int releaseYear);
    void deleteById(Long id);
}

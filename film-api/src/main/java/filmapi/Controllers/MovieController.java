package filmapi.Controllers;
import filmapi.Classes.Movie;
import filmapi.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    public MovieRepository movieRepository;
    @GetMapping("")
    public ResponseEntity<List<Movie>> getAll(){
        return ResponseEntity.ok(movieRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(movieRepository.findById(id));
    }
    @GetMapping("/title/{title}")
    public ResponseEntity<?> getByName(@PathVariable("title") String title) {
        title=title+"%";
        return ResponseEntity.ok(movieRepository.findByTitleLike(title));
    }
    @GetMapping("/year/{year}")
    public ResponseEntity<?> findByReleaseYear(@PathVariable("year") int year) {
        return ResponseEntity.ok(movieRepository.findByReleaseYear(year));
    }
    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<?> postMovie(@RequestBody List<Movie> newMovieList) {
        movieRepository.saveAllAndFlush(newMovieList);
        return ResponseEntity.ok(200);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        movieRepository.deleteById(id);
        return ResponseEntity.ok(200);
    }
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> UpdateById(@RequestBody Movie movie, @PathVariable("id") Long id) {
        return movieRepository.findById(id)
                .map(movie1 ->{
                    movie1.setTitle(movie.getTitle());
                    movie1.setReleaseYear(movie.getReleaseYear());
                    movie1.setBlurb(movie.getBlurb());
                    movie1.setDirector(movie.getDirector());
                    movie1.setRuntime(movie.getRuntime());
                    return ResponseEntity.ok(movieRepository.saveAndFlush(movie1));
                })
                .orElseGet(()->{
                    movie.setId(id);
                    return ResponseEntity.ok(movieRepository.saveAndFlush(movie));
                });
    }
 }

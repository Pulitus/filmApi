package filmapi.Controllers;

import filmapi.Classes.Category;
import filmapi.Classes.MovieCategory;
import filmapi.Repositories.MovieCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie-category")
public class MovieCategoryController {
    @Autowired
    public MovieCategoryRepository movieCategoryRepository;
    @GetMapping("")
    public ResponseEntity<List<MovieCategory>> getAll(){
        return ResponseEntity.ok(movieCategoryRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(movieCategoryRepository.findById(id));
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<?> findByCategory(@PathVariable("id") Long id){
        Category cat =new Category();
        cat.setId(id);
        return ResponseEntity.ok(movieCategoryRepository.findByCategory(cat));
    }
    @PostMapping("")
    @ResponseBody
    public ResponseEntity<?> postMovieCategory(@RequestBody List<MovieCategory> newMovieCategoryList) {
        movieCategoryRepository.saveAllAndFlush(newMovieCategoryList);
        return ResponseEntity.ok(200);
    }
}

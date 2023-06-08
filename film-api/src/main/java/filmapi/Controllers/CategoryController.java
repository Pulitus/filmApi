package filmapi.Controllers;

import filmapi.Classes.Category;
import filmapi.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    public CategoryRepository categoryRepository;

    @GetMapping("")
    public ResponseEntity<List<Category>> getAll(){
        return ResponseEntity.ok(categoryRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(categoryRepository.findById(id));
    }
    @GetMapping("/name/{category}")
    public ResponseEntity<?> getByName(@PathVariable("category") String category){

        return ResponseEntity.ok(categoryRepository.findByCategory(category));
    }
    @PostMapping("")
    @ResponseBody
    public ResponseEntity<?> postCategory(@RequestBody List<Category> newCategoryList) {
            categoryRepository.saveAllAndFlush(newCategoryList);
            return ResponseEntity.ok(200);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        categoryRepository.deleteById(id);
        return ResponseEntity.ok(200);
    }
}

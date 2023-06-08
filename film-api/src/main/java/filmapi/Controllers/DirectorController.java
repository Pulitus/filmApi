package filmapi.Controllers;


import filmapi.Classes.Director;
import filmapi.Classes.Review;
import filmapi.Repositories.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/director")
public class DirectorController {
    @Autowired
    public DirectorRepository directorRepository;

    @GetMapping("")
    public ResponseEntity<List<Director>> getAll(){
        return ResponseEntity.ok(directorRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(directorRepository.findById(id));
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<?> getByName(@PathVariable("name") String name){
        name=name+"%";
        return ResponseEntity.ok(directorRepository.findByNameLike(name));
    }
    @PostMapping("")
    @ResponseBody
    public ResponseEntity<?> postCategory(@RequestBody List<Director> newDirectorList) {
        directorRepository.saveAllAndFlush(newDirectorList);
        return ResponseEntity.ok(200);
    }

}

package filmapi.Controllers;

import filmapi.Classes.Movie;
import filmapi.Classes.Review;
import filmapi.Repositories.MovieRepository;
import filmapi.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    public ReviewRepository reviewRepository;
    public MovieRepository movieRepository;
    @GetMapping("")
    public ResponseEntity<List<Review>> getAll(){
        return ResponseEntity.ok(reviewRepository.findAll());
    }
    @PostMapping("")
    @ResponseBody
    public ResponseEntity<?> postCategory(@RequestBody List<Review> newReviewList) {
        reviewRepository.saveAllAndFlush(newReviewList);
        return ResponseEntity.ok(200);
    }
}

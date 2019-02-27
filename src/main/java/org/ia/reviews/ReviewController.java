package org.ia.reviews;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ReviewController {

    private Storage reviewStorage;
    RestTemplate restTemplate;

    public ReviewController(Storage reviewStorage) {
        this.reviewStorage = reviewStorage;
    }

    @GetMapping("/reviews")
    public List<Review> getAll() {
        return reviewStorage.findAll();
    }

    @GetMapping("/reviews/{id}")
    public Review getOne(@PathVariable Long id) {
        return reviewStorage.findById(id).orElseThrow( () -> new ReviewException("No review with id " + id) );
    }

    @PostMapping("/reviews")
    public Review create(@RequestBody Review review) {
        return reviewStorage.save(review);
    }

//    @GetMapping("/televisions")
//    public void getTelevisions() {
//        restTemplate.getForObject("https://")
//        System.out.println();
//    }
}

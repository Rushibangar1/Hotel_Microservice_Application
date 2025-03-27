package com.app.Rating.RatingService.Controller;



import com.app.Rating.RatingService.Model.Rating;
import com.app.Rating.RatingService.Service.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rating")
public class RatingController {


    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }


    @PostMapping("/giveRating")
    public ResponseEntity<Rating> create(@RequestBody Rating rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    //get all
    @GetMapping("/getAllRatings")
    public ResponseEntity<List<Rating>> getRatings() {
        return ResponseEntity.ok(ratingService.getRatings());
    }


    @GetMapping("/users/{userId}")
    public ResponseEntity<Rating> getRatingsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

    //get all of hotels
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<Rating> getRatingsByHotelId(@PathVariable Long hotelId) {
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }






}

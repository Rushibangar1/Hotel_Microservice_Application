package com.app.Rating.RatingService.Controller;

import com.app.Rating.RatingService.Model.Rating;
import com.app.Rating.RatingService.Service.RatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rating")
public class RatingController {

    // Logger initialization
    private static final Logger log = LoggerFactory.getLogger(RatingController.class);

    private final RatingService ratingService;

    // Constructor-based injection for RatingService
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    // Endpoint to create a new rating
    @PostMapping("/giveRating")
    public ResponseEntity<Rating> create(@RequestBody Rating rating) {
        log.info("Received request to give a rating: {}", rating);  // Log the rating object
        Rating createdRating = ratingService.create(rating);
        log.info("Rating created successfully with ID: {}", createdRating.getRatingId());// Log the created rating ID
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRating);
    }

    // Endpoint to get all ratings
    @GetMapping("/getAllRatings")
    public ResponseEntity<List<Rating>> getRatings() {
        log.info("Fetching all ratings");  // Log that we are fetching all ratings
        List<Rating> ratings = ratingService.getRatings();
        log.info("Fetched {} ratings", ratings.size());  // Log the number of ratings fetched
        return ResponseEntity.ok(ratings);
    }

    // Endpoint to get ratings by user ID
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable Long userId) {
        log.info("Received request to fetch ratings for user with ID: {}", userId);  // Log the userId
        List<Rating> ratings = ratingService.getRatingByUserId(userId);
        if (ratings.isEmpty()) {
            log.warn("No ratings found for user with ID: {}", userId);  // Log warning if no ratings are found
        } else {
            log.info("Fetched {} ratings for user with ID: {}", ratings.size(), userId);  // Log the number of ratings fetched
        }
        return ResponseEntity.ok(ratings);
    }

    // Endpoint to get ratings by hotel ID
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable Long hotelId) {
        log.info("Received request to fetch ratings for hotel with ID: {}", hotelId);  // Log the hotelId
        List<Rating> ratings = ratingService.getRatingByHotelId(hotelId);
        if (ratings.isEmpty()) {
            log.warn("No ratings found for hotel with ID: {}", hotelId);  // Log warning if no ratings are found
        } else {
            log.info("Fetched {} ratings for hotel with ID: {}", ratings.size(), hotelId);  // Log the number of ratings fetched
        }
        return ResponseEntity.ok(ratings);
    }
}

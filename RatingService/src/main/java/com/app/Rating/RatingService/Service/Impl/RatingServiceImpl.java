package com.app.Rating.RatingService.Service.Impl;

import com.app.Rating.RatingService.Exception.ResourceNotFoundException;
import com.app.Rating.RatingService.Model.Rating;
import com.app.Rating.RatingService.Repository.RatingRepository;
import com.app.Rating.RatingService.ResponseMessage.RespMessage;
import com.app.Rating.RatingService.Service.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    public RatingServiceImpl (RatingRepository  ratingRepository){
        this.ratingRepository = ratingRepository;
    }


    @Override
    public Rating create(Rating rating) {
        return  ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public ResponseEntity<List<?>> getRatingByUserId(Long userId) {
        if(userId == null || userId <=0 ){
            RespMessage errorMessage = new RespMessage();
            errorMessage.setMessage("Invalid user ID provided. Please provide a valid user ID.");

            return  ResponseEntity.badRequest().body(Collections.singletonList(errorMessage));
        }
        // Fetch ratings from the repository
        List<Rating> ratings = ratingRepository.findByUserId(userId);

        // Check if ratings were found
        if (ratings == null || ratings.isEmpty()) {
            // Create an error message for no ratings found
            RespMessage noRatingsMessage = new RespMessage();
            noRatingsMessage.setMessage("No ratings found for the provided user ID.");

            // Return a 404 Not Found response with the no ratings message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonList(noRatingsMessage));
        }
        // Return the list of ratings with a 200 OK response
        return ResponseEntity.ok(ratings);
    }
    @Override
    public List<Rating> getRatingByHotelId(Long hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}

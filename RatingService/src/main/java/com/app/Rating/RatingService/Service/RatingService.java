package com.app.Rating.RatingService.Service;

import com.app.Rating.RatingService.Model.Rating;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {


    //create
    Rating create(Rating rating);


    //get all ratings
    List<Rating> getRatings();

    //get all by UserId
     ResponseEntity<List<?>> getRatingByUserId(Long userId);

    //get all by hotel
     List<Rating>getRatingByHotelId(Long hotelId);
}
//rating need to list
//erro in fetching the rating via uservice
//
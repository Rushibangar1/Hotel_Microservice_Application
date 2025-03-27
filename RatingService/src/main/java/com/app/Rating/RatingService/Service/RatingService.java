package com.app.Rating.RatingService.Service;

import com.app.Rating.RatingService.Model.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {


    //create
    Rating create(Rating rating);


    //get all ratings
    List<Rating> getRatings();

    //get all by UserId
     Rating getRatingByUserId(Long userId);

    //get all by hotel
     Rating getRatingByHotelId(Long hotelId);
}

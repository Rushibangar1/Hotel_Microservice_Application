package com.app.Rating.RatingService.Service.Impl;

import com.app.Rating.RatingService.Exception.ResourceNotFoundException;
import com.app.Rating.RatingService.Model.Rating;
import com.app.Rating.RatingService.Repository.RatingRepository;
import com.app.Rating.RatingService.Service.RatingService;
import org.springframework.stereotype.Service;

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
    public Rating getRatingByUserId(Long userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public Rating getRatingByHotelId(Long hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

}

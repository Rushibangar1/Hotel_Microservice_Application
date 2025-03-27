package com.app.Rating.RatingService.Repository;

import com.app.Rating.RatingService.Model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Long> {


    Rating findByUserId (Long UserID);
    Rating findByHotelId(Long UserID);

}

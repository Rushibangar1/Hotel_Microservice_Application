package com.app.user.service.userService.external_service;


import com.app.user.service.userService.Model.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Service
@FeignClient(name="RATINGSERVICE")
public interface RatingService {


    @PostMapping("/giveRating")
    public ResponseEntity<Rating> createRating(Rating values);

}

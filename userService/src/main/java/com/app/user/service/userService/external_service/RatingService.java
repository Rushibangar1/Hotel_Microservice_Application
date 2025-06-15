package com.app.user.service.userService.external_service;


import com.app.user.service.userService.ResponseDto.Rating_Response_Dto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@FeignClient(name="RATINGSERVICE")
public interface RatingService {


    @PostMapping("/giveRating")
    public ResponseEntity<Rating_Response_Dto> createRating(Rating_Response_Dto values);


    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating_Response_Dto>> getRatingsByUserId(@PathVariable Long userId);



}

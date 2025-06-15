package com.app.user.service.userService.Service.impl;





import com.app.user.service.userService.Exception.ResourceNotFoundException;
import com.app.user.service.userService.ResponseDto.Hotel_Response_Dto;
import com.app.user.service.userService.ResponseDto.Rating_Response_Dto;
import com.app.user.service.userService.Model.User;

import com.app.user.service.userService.Repository.UserRepository;
import com.app.user.service.userService.Service.UserService;
import com.app.user.service.userService.external_service.HotelService;
import com.app.user.service.userService.external_service.RatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final HotelService hotelService;

    private final UserRepository userRepository;

    private final RatingService ratingService;

    private final RestTemplate restTemplate;


    public UserServiceImpl(HotelService hotelService, UserRepository userRepository, RatingService ratingService, RestTemplate restTemplate) {
        this.hotelService = hotelService;
        this.userRepository = userRepository;
        this.ratingService = ratingService;
        this.restTemplate = restTemplate;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException
                        ("User with the given id is not available"
                                +userId));



      List<Rating_Response_Dto> ratingsOfUser = ratingService.getRatingsByUserId(user.getUserId()).getBody();

      if(ratingsOfUser.isEmpty()){

      }


        List<Rating_Response_Dto> ratingList = ratingsOfUser.stream().map(rating -> {
            Hotel_Response_Dto hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRating(ratingList);
                 return user;
    }
}

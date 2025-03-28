package com.app.user.service.userService.Service.impl;





import com.app.user.service.userService.Exception.ResourceNotFoundException;
import com.app.user.service.userService.Model.Hotel;
import com.app.user.service.userService.Model.Rating;
import com.app.user.service.userService.Model.User;

import com.app.user.service.userService.Repository.UserRepository;
import com.app.user.service.userService.Service.UserService;
import com.app.user.service.userService.external_service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final HotelService hotelService;

    private final UserRepository userRepository;

    private final RestTemplate restTemplate;


    public UserServiceImpl(HotelService hotelService, UserRepository userRepository, RestTemplate restTemplate) {
        this.hotelService = hotelService;
        this.userRepository = userRepository;
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


        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATINGSERVICE/api/rating/users/" + user.getUserId(), Rating[].class);


        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
        List<Rating> ratingList = ratings.stream().map(rating -> {
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRating(ratingList);
                 return user;

    }
}

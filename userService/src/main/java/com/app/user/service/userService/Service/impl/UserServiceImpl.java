package com.app.user.service.userService.Service.impl;



import com.app.user.service.userService.Hotel;

import com.app.user.service.userService.Exception.ResourceNotFoundException;
import com.app.user.service.userService.Model.Rating;
import com.app.user.service.userService.Model.User;
import com.app.user.service.external.services.HotelService;
import com.app.user.service.userService.Repository.UserRepository;
import com.app.user.service.userService.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);





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



        return userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException
                        ("User with the given id is not available"
                                +userId));


        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(), Rating[].class);
        logger.info("{} ", ratingsOfUser);
        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
        List<Rating> ratingList = ratings.stream().map(rating -> {
            //api call to hotel service to get the hotel
            http://localhost:8082/hotels/1cbaf36d-0b28-4173-b5ea-f1cb0bc0a791
            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
             logger.info("response status code: {} ",forEntity.getStatusCode());
           // set the hotel to rating
            rating.setHotel(hotel);
           // return the rating
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);



        return user;





    }
}

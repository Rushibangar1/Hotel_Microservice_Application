package com.app.user.service.userService.Controller;

import com.app.user.service.userService.Model.User;
import com.app.user.service.userService.Repository.UserRepository;
import com.app.user.service.userService.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User userPayload){
        User user  =   userService.saveUser(userPayload);
        log.info("user saved info {}",user);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }


    @GetMapping("/getUser/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable Long userId){
        User user  =   userService.getUser(userId);
        log.info("Retrived user info {}",user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser  =   userService.getAllUser();
        log.info("Retrived  all user info {}",allUser);
        return ResponseEntity.ok(allUser);
    }









}

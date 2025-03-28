package com.app.user.service.userService.Service;

import com.app.user.service.userService.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(Long userId);





}

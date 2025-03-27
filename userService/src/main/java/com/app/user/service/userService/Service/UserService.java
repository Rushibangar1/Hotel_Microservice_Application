package com.app.user.service.userService.Service;

import com.app.user.service.userService.Model.User;

import java.util.List;

public interface UserService {





    User saveUser(User user);

    List<User> getAllUser();

    User getUser(Long userId);





}

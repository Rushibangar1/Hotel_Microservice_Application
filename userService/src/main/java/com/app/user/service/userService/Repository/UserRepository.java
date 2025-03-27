package com.app.user.service.userService.Repository;

import com.app.user.service.userService.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {
}

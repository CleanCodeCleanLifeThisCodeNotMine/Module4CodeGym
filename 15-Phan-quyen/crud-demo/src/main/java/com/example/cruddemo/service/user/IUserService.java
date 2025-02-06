package com.example.cruddemo.service.user;

import com.example.cruddemo.model.User;
import com.example.cruddemo.service.IGenericService;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserService extends IGenericService<User> {
    UserDetails loadUserByUsername(String username);
    User findByUsername(String username);
}

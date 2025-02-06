package org.example.demojwtc04.service.user;

import org.example.demojwtc04.model.User;
import org.example.demojwtc04.service.IGenericService;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserService extends IGenericService<User> {
    UserDetails loadUserByUsername(String username);
    User findByUsername(String username);
}

package com.joacog.ecommerce.service;

import com.joacog.ecommerce.model.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface IUserService {
    User getUserById(Long id);
    List<User> getUsers();
    void createUser(User user);
    void deleteUserById(Long id);
    User editCompleteUser(Long id,User user);
    User patchUser(Long id);
}

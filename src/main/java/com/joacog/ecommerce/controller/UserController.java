package com.joacog.ecommerce.controller;

import com.joacog.ecommerce.model.User;
import com.joacog.ecommerce.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping("/create")
    public void createUser(@RequestParam User user){
        userService.createUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
    }

    @PutMapping("/c/edit/{id}")
    public User editCompleteUser(@PathVariable Long id, @RequestParam User user){
        return userService.editCompleteUser(id,user);
    }

    @PatchMapping("/edit/{id}")
    public User patchUser(@PathVariable Long id){
        //TERMINAR
        return  null;
    }
}

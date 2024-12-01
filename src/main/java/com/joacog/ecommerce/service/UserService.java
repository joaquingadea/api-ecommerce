package com.joacog.ecommerce.service;

import com.joacog.ecommerce.model.User;
import com.joacog.ecommerce.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }


    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User editCompleteUser(Long id,User user) {
        User userAux = userRepository.findById(id).orElse(null);
        if (userAux != null){
            userAux = user;
            userRepository.save(userAux);
        }
        return userAux;
    }

    @Override
    public User patchUser(Long id) {
        //TERMINAR
        return null;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean existsUserByName(String username) {
        return this.findByUsername(username).isPresent();
    }



}

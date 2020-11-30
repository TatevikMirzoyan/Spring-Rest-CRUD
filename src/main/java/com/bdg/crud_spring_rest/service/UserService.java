package com.bdg.crud_spring_rest.service;

import com.bdg.crud_spring_rest.model.User;
import com.bdg.crud_spring_rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Tatevik Mirzoyan
 * Created on 12-Nov-20
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User getById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Iterable<User> iterable = userRepository.findAll();
        for (User user : iterable) {
            users.add(user);
        }
        return users;
    }

    public void updateUser(int id, User user) {
        user.setId(id);
        userRepository.save(user);
    }

    public void deleteUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent())
            userRepository.deleteById(id);
    }

    public User deleteUser(User user) {
        if (user != null) {
            userRepository.delete(user);
        }
        return user;
    }

    public long countUsers() {
        return userRepository.count();
    }


}

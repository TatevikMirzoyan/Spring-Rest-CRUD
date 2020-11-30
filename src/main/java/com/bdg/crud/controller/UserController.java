package com.bdg.crud.controller;

import com.bdg.crud.model.User;
import com.bdg.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Tatevik Mirzoyan
 * Created on 11-Nov-20
 */
@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @GetMapping(path = "/{id}")
    public User getById(@PathVariable int id) {
        return userService.getById(id);
    }

    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping(path = "update/{id}")
    public void updateUser(@PathVariable int id,@RequestBody User user) {
        userService.updateUser(id, user);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
    }

    @DeleteMapping(value = "delete")
    public User deleteUser(@RequestBody User user) {
        return userService.deleteUser(user);
    }

    @GetMapping(value = "count")
    public long countUsers() {
        return userService.countUsers();
    }
}

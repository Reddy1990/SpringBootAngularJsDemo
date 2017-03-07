package com.user.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.user.springboot.Entity.User;
import com.user.springboot.Service.UserService;

@RestController
@RequestMapping("/SpringBoot")
public class UserController {
 
    @Autowired
    UserService userService;
    
     
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> listAllUsers() {
        List<User> users = userService.findAllUsers();
        return users;
    }
 
 
    
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        User user = userService.findById(id);
       return user;
    }
 
     
     
     
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public void createUser(@RequestBody User user) {
        System.out.println("Creating User " + user.getUsername());
        userService.saveUser(user);
    }

    
    
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable("id") long id, @RequestBody User user) {
        System.out.println("Updating User " + id);
         
        User currentUser = userService.findById(id);
         
        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
       
        }
 
        currentUser.setUsername(user.getUsername());
        currentUser.setAddress(user.getAddress());
        currentUser.setEmail(user.getEmail());
         
        userService.updateUser(currentUser);
        return currentUser;
        
    }
 
    
   
     
    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    public User deleteUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);
 
        User user = userService.findById(id);
 
        userService.deleteUserById(id);
       return user;
    }
 
     
    
    
}
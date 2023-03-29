package com.boot.Curdproject.curdProject.controllers;

import com.boot.Curdproject.curdProject.dtos.ApiResponseMessage;
import com.boot.Curdproject.curdProject.dtos.UserDto;


import com.boot.Curdproject.curdProject.service.userService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class userController {
    @Autowired
    private userService userService;
    Logger logger = LoggerFactory.getLogger(userController.class);

    //create
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto userDto1 = userService.createUser(userDto);

        return new ResponseEntity<>(userDto1, HttpStatus.CREATED);
    }

    //update
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("userId") String userId, @RequestBody UserDto userDto) {
        UserDto userDto1 = userService.updateUser(userDto, userId);
        return new ResponseEntity<>(userDto1, HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponseMessage> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        ApiResponseMessage message = ApiResponseMessage.builder().message("user deleted succesfully").success(true).status(HttpStatus.OK).build();
        logger.info("user deleted {}", message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    //get all
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    //get single
    @GetMapping("/{userid}")
    public ResponseEntity<UserDto> getUser(@PathVariable String userid) {
        logger.info("user of given id {} ", userService.getUserById(userid));
        return new ResponseEntity<>(userService.getUserById(userid), HttpStatus.OK);
    }

    //get user by email
//    @GetMapping("email/{email}")
//    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email)
//    {
//        return new ResponseEntity<>(userService.getUserByEmail(email),HttpStatus.OK);
//    }

    //search user
//    @GetMapping("/{keywords}")
//    public ResponseEntity<List<UserDto>> searchUser(@PathVariable String keywords)
//    {
//        return new ResponseEntity<>(userService.searchUser(keywords),HttpStatus.OK);
//    }
}

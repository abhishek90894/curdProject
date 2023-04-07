package com.boot.Curdproject.curdProject.controllers;

import com.boot.Curdproject.curdProject.dtos.ApiResponseMessage;
import com.boot.Curdproject.curdProject.dtos.UserDto;
<<<<<<< HEAD
=======


>>>>>>> 55008cc44612a6bde33ed6d61464ce120bf0bb0a
import com.boot.Curdproject.curdProject.service.userService;

import jakarta.validation.Valid;
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
<<<<<<< HEAD
   private userService userService;
=======
    private userService userService;
>>>>>>> 55008cc44612a6bde33ed6d61464ce120bf0bb0a
    Logger logger = LoggerFactory.getLogger(userController.class);

    //create
    @PostMapping
<<<<<<< HEAD
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto)
    {
        UserDto userDto1 = userService.createUser(userDto);

        return  new ResponseEntity<>(userDto1, HttpStatus.CREATED);
    }
    //update
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("userId") String userId,@RequestBody @Valid UserDto userDto)
    {
        UserDto userDto1 = userService.updateUser(userDto,userId);
        return  new ResponseEntity<>(userDto1,HttpStatus.OK);
=======
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto userDto1 = userService.createUser(userDto);

        return new ResponseEntity<>(userDto1, HttpStatus.CREATED);
    }

    //update
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("userId") String userId, @RequestBody UserDto userDto) {
        UserDto userDto1 = userService.updateUser(userDto, userId);
        return new ResponseEntity<>(userDto1, HttpStatus.OK);
>>>>>>> 55008cc44612a6bde33ed6d61464ce120bf0bb0a
    }

    //delete
    @DeleteMapping("/{userId}")
<<<<<<< HEAD
    public ResponseEntity<ApiResponseMessage> deleteUser(@PathVariable String userId)
    {
        userService.deleteUser(userId);
  ApiResponseMessage message =  ApiResponseMessage.builder().message("user deleted succesfully").success(true).status(HttpStatus.OK).build();
  logger.info("user deleted {}",message);
  return  new ResponseEntity<>(message,HttpStatus.OK);
    }
    //get all
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers()
    {
        return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }
    //get single
     @GetMapping("/{userid}")
    public ResponseEntity<UserDto> getUser(@PathVariable String userid)
    {
        logger.info("user of given id {} ",userService.getUserById(userid));
        return new ResponseEntity<>(userService.getUserById(userid),HttpStatus.OK);
=======
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
>>>>>>> 55008cc44612a6bde33ed6d61464ce120bf0bb0a
    }

    //get user by email
//    @GetMapping("email/{email}")
//    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email)
//    {
//         return new ResponseEntity<>(userService.getUserByEmail(email),HttpStatus.OK);
//    }

    //search user
//    @GetMapping("/{keywords}")
//    public ResponseEntity<List<UserDto>> searchUser(@PathVariable String keywords)
//    {
//        return new ResponseEntity<>(userService.searchUser(keywords),HttpStatus.OK);
//    }
}

package com.boot.Curdproject.curdProject.service;

import com.boot.Curdproject.curdProject.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface userService {

    //create

     UserDto createUser(UserDto userDto);

    //update

     UserDto updateUser(UserDto userDto, String userId);

    //delete
          void deleteUser(String userId);
    //get all users
    List<UserDto> getAllUser();
    //get single user by email

     // get single user by id
     UserDto getUserById(String userid);

     //get userByEmail

     UserDto getUserByEmail(String email);
    //search user
//    List<UserDto> searchUser(String keyword);

}

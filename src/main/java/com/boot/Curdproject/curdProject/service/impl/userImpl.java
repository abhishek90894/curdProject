package com.boot.Curdproject.curdProject.service.impl;

import com.boot.Curdproject.curdProject.dtos.UserDto;
import com.boot.Curdproject.curdProject.entities.user;
import com.boot.Curdproject.curdProject.service.userService;
import com.boot.Curdproject.curdProject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class userImpl  implements userService {

    @Autowired
    private  userRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        String userId = UUID.randomUUID().toString();
         userDto.setUserId(userId);
        user user = dtoToEntity(userDto);
        user saveUser = userRepository.save(user);
         UserDto newDto = entityToDto(saveUser);
        return newDto;
    }




    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        user user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("userNot found"));
             user.setUserName(userDto.getUserName());
             user.setUserPassword(userDto.getUserPassword());
             user.setAbout(userDto.getGender());
             user.setImageName(userDto.getImageName());
             user updateUser = userRepository.save(user);
             UserDto updatedDto = entityToDto(updateUser);

        return updatedDto;
    }

    @Override
    public void deleteUser(String userId)
    {
        user user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("user not found"));
      userRepository.delete(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<user> users = userRepository.findAll();
      List<UserDto> dtolist =   users.stream().map(user ->entityToDto(user)).collect(Collectors.toList());
        return dtolist;
    }

    @Override
    public UserDto getUserById(String userid) {
          user user   =   userRepository.findById(userid).orElseThrow(()->new RuntimeException("user not found"));
         return  entityToDto(user);
          
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<UserDto> searchUser(String keyword) {
        return null;
    }

    private user dtoToEntity(UserDto userDto) {
    user user1 = user.builder()
            .userId(userDto.getUserId())
            .userName(userDto.getUserName())
            .userEmail(userDto.getUserEmail())
            .userPassword(userDto.getUserPassword())
            .about(userDto.getAbout())
            .imageName(userDto.getImageName())
            .gender(userDto.getGender()).build();

        return user1;

    }
    private UserDto entityToDto(user saveUser) {
      UserDto userDto = UserDto.builder()
              .userId(saveUser.getUserId())
              .userName(saveUser.getUserName())
              .userEmail(saveUser.getUserEmail())
              .userPassword(saveUser.getUserPassword())
              .about(saveUser.getAbout())
              .imageName(saveUser.getImageName())
              .build();
        return null;
    }
}

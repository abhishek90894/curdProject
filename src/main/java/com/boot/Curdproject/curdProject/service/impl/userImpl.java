package com.boot.Curdproject.curdProject.service.impl;

import com.boot.Curdproject.curdProject.dtos.UserDto;
import com.boot.Curdproject.curdProject.entities.user;
import com.boot.Curdproject.curdProject.exception.ResourceNotFoundException;
import com.boot.Curdproject.curdProject.repository.userRepository;
import com.boot.Curdproject.curdProject.service.userService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class userImpl  implements userService {

    @Autowired
    private  userRepository userRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDto createUser(UserDto userDto) {
        String userId = UUID.randomUUID().toString();
         userDto.setUserId(userId);
         // encoding password
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user user = dtoToEntity(userDto);
        user saveUser = userRepository.save(user);
         UserDto newDto = entityToDto(saveUser);
        return newDto;
    }




    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        user user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("userNot found"));
             user.setUserName(userDto.getUserName());
             user.setPassword(userDto.getPassword());
             user.setAbout(userDto.getGender());
             user.setImageName(userDto.getImageName());
             user updateUser = userRepository.save(user);
             UserDto updatedDto = entityToDto(updateUser);

        return updatedDto;
    }

    @Override
    public void deleteUser(String userId)
    {
        user user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user not found"));
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
          user user   =   userRepository.findById(userid).orElseThrow(()->new ResourceNotFoundException("user not found"));
         return  entityToDto(user);

    }

//    @Override
//    public UserDto getUserByEmail(String email) {
//        user user = userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("user not  found"));
//        return entityToDto(user);
//    }

//    @Override
//    public List<UserDto> searchUser(String keyword) {
//        List<user> user = userRepository.findByNameContaining(keyword);
//        List<UserDto> dtoList = user.stream().map(user1 ->entityToDto(user1)).collect(Collectors.toList());
//        return dtoList;
//    }

    private user dtoToEntity(UserDto userDto) {
//    user user1 = user.builder()
//            .userId(userDto.getUserId())
//            .userName(userDto.getUserName())
//            .Email(userDto.getEmail())
//            .Password(userDto.getPassword())
//            .about(userDto.getAbout())
//            .imageName(userDto.getImageName())
//            .gender(userDto.getGender()).build();

        return mapper.map(userDto,user.class);

    }
    private UserDto entityToDto(user saveUser) {
//      UserDto userDto = UserDto.builder()
//              .userId(saveUser.getUserId())
//              .userName(saveUser.getUserName())
//              .Email(saveUser.getEmail())
//              .Password(saveUser.getPassword())
//              .about(saveUser.getAbout())
//              .imageName(saveUser.getImageName())
//              .build();

        return mapper.map(saveUser,UserDto.class);
    }
}

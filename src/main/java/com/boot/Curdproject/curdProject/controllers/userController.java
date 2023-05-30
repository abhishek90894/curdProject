package com.boot.Curdproject.curdProject.controllers;

import com.boot.Curdproject.curdProject.dtos.ApiResponseMessage;
import com.boot.Curdproject.curdProject.dtos.UserDto;

import com.boot.Curdproject.curdProject.dtos.imageResponseMessage;
import com.boot.Curdproject.curdProject.service.fileService;
import com.boot.Curdproject.curdProject.service.userService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class userController {
    @Autowired
    private userService userService;

    @Autowired
    private fileService fileService;

    @Value("${user.profile.image.path}")
    private String imageUploadPath;

    Logger logger = LoggerFactory.getLogger(userController.class);

    //create
    @PostMapping
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

    }


    //delete
    @DeleteMapping("/{userId}")
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

    }

    // upload user image
       @PostMapping("/image/{userId}")
       public ResponseEntity<imageResponseMessage> uploadUserImage(@RequestParam("userImage") MultipartFile image, @PathVariable String userId) throws IOException {
              String imageName    = fileService.uploadFile(image,imageUploadPath);

                   UserDto userDto   = userService.getUserById(userId);
                   userDto.setImageName(imageName);
              UserDto updateUser    = userService.updateUser(userDto,userId);
         imageResponseMessage  imageResponse = imageResponseMessage.builder()
                 .imageName(imageName)
                 .message("image uploaded succesfully")
                 .status(HttpStatus.CREATED)
                 .success(true)
                 .build();

         return  new ResponseEntity<>(imageResponse,HttpStatus.CREATED);


    }


    // serve user image
      @GetMapping("/image/{userId}")
      public void serveUserImage(@PathVariable  String userId, HttpServletResponse response) throws IOException {
           UserDto userDto = userService.getUserById(userId);
           log.info("user image name {}",userDto.getUserName());
          InputStream resource = fileService.getResource(imageUploadPath,userDto.getImageName());
          response.setContentType(MediaType.IMAGE_JPEG_VALUE);
          StreamUtils.copy(resource,response.getOutputStream());
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

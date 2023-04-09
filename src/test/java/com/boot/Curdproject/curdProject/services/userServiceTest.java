package com.boot.Curdproject.curdProject.services;

import com.boot.Curdproject.curdProject.dtos.UserDto;
import com.boot.Curdproject.curdProject.entities.user;
import com.boot.Curdproject.curdProject.repository.userRepository;
import com.boot.Curdproject.curdProject.service.userService;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

//@ExtendWith(SpringExtension.class)
@Slf4j
@SpringBootTest
public class userServiceTest {

    // create user

    @Autowired
     private userService  userService;
    @MockBean     // spring understand this mock repo i have to insert
    private userRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    user user1;

    @BeforeEach
    public  void init()
    {
          user1 = user.builder()
                   .userName("abhishek srivastava")

                 .Email("abhi@gmail.com")
                 .about("this is testing")
                 .gender("male")
                 .imageName("abhi.jpeg")
                 .Password("1234567")
                 .build();
    }

    @Test
    public void createUserTest()
    {
        Mockito.when(userRepository.save(Mockito.any())).thenReturn(user1);

         UserDto userDto  = userService.createUser(mapper.map(user1, UserDto.class));

         log.info("user name {}",userDto.getUserName());
         Assertions.assertNotNull(userDto);

        // Assertions.assertEquals("abhishek srivastava",userDto.getUserName());


    }
    @Test
    public void updateUserTest()
    {
        String userId = "12dse45";
        UserDto userDto = UserDto.builder()
                .userName("abhishek")

                .Email("abhi@gmail.com")
                .about("this is testing")
                .gender("male")
                .imageName("abhi.jpeg")
                .Password("1234567")
                .build();

        Mockito.when(userRepository.findById(Mockito.anyString())).thenReturn(Optional.of(user1));
        Mockito.when(userRepository.save(Mockito.any())).thenReturn(user1);
        UserDto userDto1 = userService.updateUser(userDto,userId);
        log.info("updated user {}",userDto1);

        Assertions.assertEquals("abhishek",userDto1.getUserName());
    }

}

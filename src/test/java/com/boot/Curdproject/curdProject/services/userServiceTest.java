package com.boot.Curdproject.curdProject.services;

import com.boot.Curdproject.curdProject.dtos.UserDto;
import com.boot.Curdproject.curdProject.entities.user;
import com.boot.Curdproject.curdProject.exception.ResourceNotFoundException;
import com.boot.Curdproject.curdProject.repository.userRepository;
import com.boot.Curdproject.curdProject.service.userService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

//@ExtendWith(SpringExtension.class)
@Slf4j
@SpringBootTest
 class userServiceTest {

    // create user

    @Autowired
    private userService userService;


    @MockBean    // spring understand this mock repo i have to insert
    private userRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    user user1;

    @BeforeEach
     void init() {
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
     void createUserTest() {
        when(userRepository.save(Mockito.any())).thenReturn(user1);

        UserDto userDto = userService.createUser(mapper.map(user1, UserDto.class));

        log.info("user name {}", userDto.getUserName());
        Assertions.assertNotNull(userDto);

        // Assertions.assertEquals("abhishek srivastava",userDto.getUserName());


    }

    @Test
     void updateUserTest() {
        String userId = "12dse45";
        UserDto userDto = UserDto.builder()
                .userName("abhishek srivastava")

                .Email("abhi@gmail.com")
                .about("this")
                .gender("male")
                .imageName("abhi.jpeg")
                .Password("1234567")
                .build();

        when(userRepository.findById(anyString())).thenReturn(Optional.of(user1));
        when(userRepository.save(Mockito.any())).thenReturn(user1);
        UserDto userDto1 = userService.updateUser(userDto, userId);

        log.info("updated user {}", userDto1);
        Assertions.assertNotNull(userDto1);
        Assertions.assertEquals(userDto.getUserName(), userDto1.getUserName(), "name is not validated");

    }

//    @Test
//    public void updateUserTest_userNotfound()
//    {
//        String userId = "12dse45";
//        UserDto userDto = UserDto.builder()
//                .userName("abhishek srivastava")
//
//                .Email("abhi@gmail.com")
//                .about("this")
//                .gender("male")
//                .imageName("abhi.jpeg")
//                .Password("1234567")
//                .build();
//
//        when(userRepository.findById(anyString())).thenReturn(Optional.empty());
//        try {
//            userService.getUserById(userId);
//            Assertions.fail("Expected ResourceNotFoundException to be thrown");
//        } catch (RuntimeException e) {
//            // Assert
//            Assertions.assertEquals("user not found", e.getMessage());
//        }
//
//    }

    @Test
    void testUpdateUserWhenUserNotFound() {
        // given
        String userId = "1";
        UserDto userDto = UserDto.builder()
                .userName("abhishek srivastava")

                .Email("abhi@gmail.com")
                .about("this")
                .gender("male")
                .imageName("abhi.jpeg")
                .Password("1234567")
                .build();
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // when + then
        Assertions.assertThrows(RuntimeException.class, () -> userService.updateUser(userDto, userId));
        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, never()).save(any());
    }


    // delete user test case
    @Test
     void deleteUserTest() {
        String userId = "abc123";
        when(userRepository.findById("abc123")).thenReturn(Optional.of(user1));
        userService.deleteUser(userId);
        verify(userRepository, times(1)).delete(user1);

    }
    @Test
     void deleteUserTest_userNotFound()
    {
      String  userId = "abhc";
        when(userRepository.findById(anyString())).thenReturn(Optional.empty());

        Assertions.assertThrows(RuntimeException.class, () -> userService.deleteUser(userId));
        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, never()).delete(any());

    }

    @Test
     void getAllUsersTest() {
        user user2 = user.builder()
                .userName("ankur srivastava")

                .Email("ankur@gmail.com")
                .about("this is testing")
                .gender("male")
                .imageName("ankur.jpeg")
                .Password("765432")
                .build();

        user user3 = user.builder()
                .userName("raghav srivastava")

                .Email("raghav@gmail.com")
                .about("this is testing")
                .gender("male")
                .imageName("raghav.jpeg")
                .Password("7812345")
                .build();

        List<user> users = Arrays.asList(user1, user2, user3);

        when(userRepository.findAll()).thenReturn(users);
        List<UserDto> userDtos = userService.getAllUser();
        log.info("list of users {}", userDtos);
        Assertions.assertEquals(3, userDtos.size(), "something went wrong");

    }

    @Test
     void getUserByIdTest01() {

        String userid = "abc123";
        when(userRepository.findById("abc123")).thenReturn(Optional.of(user1));

        UserDto userDto = userService.getUserById(userid);
        Assertions.assertEquals(user1.getUserName(), userDto.getUserName(), "invalid user name");
        Assertions.assertEquals(user1.getEmail(), userDto.getEmail(), "invalid user email");
    }


    @Test
     void testGetUserById_UserNotFound() {
        // Arrange
        when(userRepository.findById(anyString())).thenReturn(Optional.empty());

        // Act
        try {
            userService.getUserById("user1");
            Assertions.fail("Expected ResourceNotFoundException to be thrown");
        } catch (ResourceNotFoundException e) {
            // Assert
            Assertions.assertEquals("user not found", e.getMessage());
        }
    }



//    @Test
//    public void getUserByEmailTest()
//    {
//     String emailId = "abhi@gmail.com";
//     Mockito.when(userRepository.findByEmail(emailId)).thenReturn(Optional.of(user1));
//        UserDto userDto  = userService.getUserByEmail(emailId);
//        Assertions.assertNotNull(userDto);
//        Assertions.assertEquals(user1.getEmail(),userDto.getEmail(),"email not matched");
//
//
//    }


}

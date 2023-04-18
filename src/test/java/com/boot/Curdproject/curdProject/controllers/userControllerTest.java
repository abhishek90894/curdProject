package com.boot.Curdproject.curdProject.controllers;

import com.boot.Curdproject.curdProject.dtos.UserDto;
import com.boot.Curdproject.curdProject.entities.user;
import com.boot.Curdproject.curdProject.service.userService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
 class userControllerTest {

    private user user1;
    @Autowired
    private ModelMapper mapper;
    @MockBean
    private userService userService;
    @Autowired
    private MockMvc mockMvc;

    //private WireMockServer wireMockServer;


    @BeforeEach
     void init() {

//        wireMockServer = new WireMockServer();
//            WireMock.configureFor("localhost",8080);
//           wireMockServer.start();

        user1 = user.builder()
                .userName("abhishek srivastava")

                .Email("abhi@gmail.com")
                .about("this is testing")
                .gender("male")
                .imageName("abhi.jpeg")
                .Password("1234567")
                .build();
    }
    //@AfterEach
//    public void tearUp()
//    {
//       wireMockServer.stop();
//    }

    // create user
    @Test
    @DisplayName("user test case")
     void createUserTest() throws Exception {
        //   /users  +POST + send user data as a json
        //  data as a json and status we get is created
        UserDto userDto = mapper.map(user1, UserDto.class);
        when(userService.createUser(Mockito.any())).thenReturn(userDto);

        // actual request for url

//        this.mockMvc.perform(MockMvcRequestBuilders.post("/users")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(convertObjectToJsonString(user1))
//                        .accept(MediaType.APPLICATION_JSON))
//
//                        .andDo(print())
//                        .andExpect(status().isCreated())
//                        .andExpect(jsonPath("$.userName").exists());


        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonString(user1));

        ResultActions perform = mockMvc.perform(requestBuilder);
        MvcResult andReturn = perform.andReturn();
        MockHttpServletResponse response = andReturn.getResponse();
        int status = response.getStatus();
        assertEquals(201, status);

    }

    //    @Test
//     public void createUserTest2()
//     {
//         // Create a WireMock server
//         WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8080));
//         // Start the server
//         wireMockServer.start();
//
//         // Set up the stub
//         stubFor(post(urlEqualTo("/users"))
//                 .withRequestBody(equalToJson("{\"userName\":\"abhishek\",\"gender\":\"male\",\"Email\":\"abhishek@gmail.com\"}"))
//                 .willReturn(aResponse()
//                         .withStatus(HttpStatus.CREATED.value())
//                         .withHeader("Content-Type", "application/json")
//                         .withBody("{\"userName\":\"abhishek\",\"gender\":\"male\",\"Email\":\"abhishek@gmail.com\"}")));
//
//         // Make a request to the stub
//         UserDto userDto = new UserDto();
//         userDto.setUserName("John");
//         userDto.setGender("male");
//         userDto.setEmail("abhishek@gmail.com");
//
//         RestTemplate restTemplate = new RestTemplate();
//
//
//         ResponseEntity<UserDto> responseEntity = restTemplate.postForEntity("http://localhost:8080/users", userDto, UserDto.class);
//
//         // Assert the response
//         assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
//         assertEquals(userDto, responseEntity.getBody());
//
//// Stop the server
//         wireMockServer.stop();
//     }
//
//
    @Test
     void updateUserTest() throws Exception {

        //  /users/{userid} + put request + json
        String userId = "123";
        UserDto userDto = mapper.map(user1, UserDto.class);
        when(userService.updateUser(Mockito.any(), Mockito.anyString())).thenReturn(userDto);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/users/" + userId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(convertObjectToJsonString(user1))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userName").exists());

    }

    @Test
     void getAllUsersTest() throws Exception {
        UserDto userDto1 = UserDto.builder().userName("abhishek srivastava").Email("abhi@gmail.com").about("this is testing").gender("male").imageName("abhi.jpeg").Password("1234567").build();
        UserDto userDto2 = UserDto.builder().userName("abhinav srivastava").Email("abhi@gmail.com").about("this is testing").gender("male").imageName("abhi.jpeg").Password("1234567").build();

        List<UserDto> userDtos = List.of(userDto1, userDto2);
        UserDto userDto = mapper.map(user1, UserDto.class);
        when(userService.getAllUser()).thenReturn(userDtos);

//            this.mockMvc.perform(MockMvcRequestBuilders.get("/users")
//                            .contentType(MediaType.APPLICATION_JSON)
//
//                            .accept(MediaType.APPLICATION_JSON))
//                    .andDo(print())
//                    .andExpect(status().isOk());

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/users"); // use to create request
        ResultActions perform = mockMvc.perform(mockHttpServletRequestBuilder); // use to send the request
        MvcResult mvcResult = perform.andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        int status = response.getStatus();
        assertEquals(200, status);


    }

    @Test
     void deleteUserTest() throws Exception {
        String userId = "abc12345678";
        userService.deleteUser(userId);

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.delete("/users/" + userId); // use to create request
        ResultActions perform = mockMvc.perform(mockHttpServletRequestBuilder); // use to send the request
        MvcResult mvcResult = perform.andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        int status = response.getStatus();
        assertEquals(200, status);

    }

    @Test
     void getUserByIdTest() throws Exception {
        String userId = "abc12345678";
        user1 = user.builder()
                .userName("abhishek srivastava")

                .Email("abhi@gmail.com")
                .about("this is testing")
                .gender("male")
                .imageName("abhi.jpeg")
                .Password("1234567")
                .build();
        UserDto userDto = mapper.map(user1, UserDto.class);
        Mockito.when(userService.getUserById(Mockito.anyString())).thenReturn(userDto);

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/users/" + userId); // use to create request
        ResultActions perform = mockMvc.perform(mockHttpServletRequestBuilder); // use to send the request
        MvcResult mvcResult = perform.andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        int status = response.getStatus();
        assertEquals(200, status);


    }

//    @Test
//    public void testGetUserById() throws Exception {
//
//        TestRestTemplate restTemplate = new TestRestTemplate();
//
//        String userId = "123";
//        UserDto userDto = new UserDto();
//        userDto.setUserId(userId);
//        userDto.setUserName("abhishek");
//        userDto.setEmail("abhishek@gmail.com");
//        userDto.setGender("male");
//        userDto.setAbout("this is abhishek");
//        userDto.setPassword("23451678");
//        userDto.setImageName("abhi.jpeg");
//
//
//        // Stubbing the response of the userService.getUserById() method
//        stubFor(get(urlEqualTo("/users/" + userId))
//                .willReturn(aResponse()
//                        .withStatus(200)
//                        .withHeader("Content-Type", "application/json")
//                        .withBody(convertObjectToJsonString(userDto))));
//
//        // When
//        ResponseEntity<UserDto> response = restTemplate.getForEntity("http://localhost:8080/users/" + userId, UserDto.class);
//
//        // Then
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(userDto.toString(), response.getBody().toString());
//
//    }


    private String convertObjectToJsonString(Object user1) {

        try {
            return new ObjectMapper().writeValueAsString(user1);
        } catch (Exception e) {
            return null;
        }
    }


}

package com.boot.Curdproject.curdProject.controllers;

import com.boot.Curdproject.curdProject.dtos.CategoryDto;
import com.boot.Curdproject.curdProject.entities.Category;
import com.boot.Curdproject.curdProject.service.categoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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

import static org.mockito.Mockito.when;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
 class categoryControllerTest {

    private Category category;
    @Autowired
    private ModelMapper mapper;
    @MockBean
    private categoryService categoryService;
    @Autowired
    private MockMvc mockMvc;
    @BeforeEach
    void init()
    {
        category = Category.builder().title("telivision")
                .coverImage("sony.jpeg")
                .description("this is sony television tv")
                .build();
    }
    @Test
    void createCategoryTest() throws Exception
    {
        CategoryDto categoryDto = mapper.map(category,CategoryDto.class);
           when(categoryService.create(Mockito.any())).thenReturn(categoryDto);

           MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/category")
                   .contentType(MediaType.APPLICATION_JSON)
                   .content(convertObjectToJsonString(category));

        ResultActions perform =  mockMvc.perform(mockHttpServletRequestBuilder); //use to send the request

        MvcResult mvcResult = perform.andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        int status = response.getStatus();
        Assertions.assertEquals(200,status);

    }

    private String convertObjectToJsonString(Category category) {
        try {
            return new ObjectMapper().writeValueAsString(category);
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}

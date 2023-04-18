package com.boot.Curdproject.curdProject.services;

import com.boot.Curdproject.curdProject.dtos.CategoryDto;
import com.boot.Curdproject.curdProject.entities.Category;
import com.boot.Curdproject.curdProject.repository.categoryRepository;
import com.boot.Curdproject.curdProject.service.categoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

public class categoryServiceTest {

    private  Category category;
    @Autowired
    private categoryService categoryService;
    @MockBean
    private categoryRepository categoryRepository;

    @Autowired
    private ModelMapper mapper;

    @BeforeEach
    public void init()
    {
         category = Category.builder().title("telivision")
                .coverImage("sony.jpeg")
                .description("this is sony television tv")
                .build();
    }

    @Test
    void createCategoryTest()
    {
         Mockito.when(categoryRepository.save(Mockito.any())).thenReturn(category);
         CategoryDto categoryDto = categoryService.create(mapper.map(category, CategoryDto.class));
    }
}

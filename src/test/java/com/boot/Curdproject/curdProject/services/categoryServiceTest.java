package com.boot.Curdproject.curdProject.services;

import com.boot.Curdproject.curdProject.repository.categoryRepository;
import com.boot.Curdproject.curdProject.service.categoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

public class categoryServiceTest {

    @Autowired
    private categoryService categoryService;
    @MockBean
    private categoryRepository categoryRepository;

    @Autowired
    private ModelMapper mapper;

    @BeforeEach
    public void init()
    {

    }

    @Test
    void createCategoryTest()
    {

    }
}

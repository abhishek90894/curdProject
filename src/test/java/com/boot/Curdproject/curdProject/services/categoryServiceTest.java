package com.boot.Curdproject.curdProject.services;

import com.boot.Curdproject.curdProject.dtos.CategoryDto;
import com.boot.Curdproject.curdProject.entities.Category;
import com.boot.Curdproject.curdProject.exception.ResourceNotFoundException;
import com.boot.Curdproject.curdProject.repository.categoryRepository;
import com.boot.Curdproject.curdProject.service.categoryService;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@Slf4j
@SpringBootTest
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
         when(categoryRepository.save(any())).thenReturn(category);
         CategoryDto categoryDto = categoryService.create(mapper.map(category, CategoryDto.class));
         Assertions.assertNotNull(categoryDto);

    }
    @Test
    void updateCategoryTest()
    {
        String id = "abc12345";
     CategoryDto categoryDto = CategoryDto.builder().title("telivision")
                .coverImage("sony.jpeg")
                .description("this is sony television tv")
                .build();

        when(categoryRepository.findById(Mockito.anyString())).thenReturn(Optional.of(category));
        when(categoryRepository.save(any())).thenReturn(category);
        CategoryDto categoryDto1 = categoryService.update(categoryDto,id);
        Assertions.assertEquals(categoryDto.toString(),categoryDto1.toString());
    }
    @Test
    void updateCategoryTestCategoryNotFound()
    {
        String id ="abc12345";
        CategoryDto categoryDto = CategoryDto.builder().title("telivision")
                .coverImage("sony.jpeg")
                .description("this is sony television tv")
                .build();
        when(categoryRepository.findById(any())).thenReturn(Optional.empty());
        Assertions.assertThrows(ResourceNotFoundException.class,()->categoryService.update(categoryDto,id));
        verify(categoryRepository, times(1)).findById(id);
        verify(categoryRepository, never()).save(any());
    }
    @Test
    void deleteCategoryTest()
    {
        String id ="abc12345";
        when(categoryRepository.findById(Mockito.anyString())).thenReturn(Optional.of(category));
            categoryService.delete(id);
            verify(categoryRepository,times(1)).delete(category);
    }
    @Test
    void deleteCategoryTest_CategoryNotFound()
    {
        String id = "abc12345";
        when(categoryRepository.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThrows(ResourceNotFoundException.class,()->categoryService.delete(id));
        verify(categoryRepository,times(1)).findById(id);
        verify(categoryRepository,never()).delete(any());
    }
    @Test
    void getAllCategoryTest()
    {
      Category  category1 = Category.builder().title("telivision")
                .coverImage("sony.jpeg")
                .description("this is sony television tv")
                .build();
      Category category2 = Category.builder().title("refrigerator")
                      .coverImage("samsung.jpeg")
                              .description("this is samsung refrigerator")
                                      .build();
      List<Category> categoryList = Arrays.asList(category1,category2);

        when(categoryRepository.findAll()).thenReturn(categoryList);
              List<CategoryDto> categoryDtos = categoryService.getAll();
              Assertions.assertEquals(2,categoryDtos.size());
    }

    @Test
    void getSingleCategoryByIdTest()
    {
        String id ="abc12345";
        when(categoryRepository.findById(id)).thenReturn(Optional.of(category));
                 CategoryDto categoryDto     =  categoryService.getSingleById(id);

                 Assertions.assertNotNull(categoryDto);
                 Assertions.assertEquals(category.getTitle(),categoryDto.getTitle());
    }
    @Test
    void getSingleCategoryByIdTest_IdNotFound()
    {
        String id = "abc12345";
        when(categoryRepository.findById(id)).thenReturn(Optional.empty());
         Assertions.assertThrows(ResourceNotFoundException.class,()->categoryService.getSingleById(id));
         verify(categoryRepository,times(1)).findById(id);

    }




}

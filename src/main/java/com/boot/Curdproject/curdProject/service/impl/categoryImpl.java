package com.boot.Curdproject.curdProject.service.impl;

import com.boot.Curdproject.curdProject.dtos.CategoryDto;
import com.boot.Curdproject.curdProject.entities.Category;
import com.boot.Curdproject.curdProject.exception.ResourceNotFoundException;
import com.boot.Curdproject.curdProject.repository.categoryRepository;
import com.boot.Curdproject.curdProject.service.categoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class categoryImpl implements categoryService {
    @Autowired
    private categoryRepository categoryRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public CategoryDto create(CategoryDto categoryDto) {

        // randomally created category id
        String categoryId1 = UUID.randomUUID().toString();
        categoryDto.setCategoryId(categoryId1);
        Category category = mapper.map(categoryDto, Category.class);
        Category saveCategory = categoryRepository.save(category);
        return mapper.map(saveCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto, String categoryId) {


        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category not found"));
        category.setDescription(categoryDto.getDescription());
        category.setTitle(categoryDto.getTitle());
        category.setCoverImage(categoryDto.getCoverImage());
         Category updateCategory = categoryRepository.save(category);

         return mapper.map(category, CategoryDto.class);
    }

    @Override
    public void delete(String categoryId) {
     Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category not found"));
     categoryRepository.delete(category);
    }

    @Override
    public List<CategoryDto> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDto = categories.stream().map(category -> mapper.map(category, CategoryDto.class)).collect(Collectors.toList());
        return categoryDto;
    }

    @Override
    public CategoryDto getSingleById(String categoryId) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category not found"));
        return mapper.map(category, CategoryDto.class);
    }
}

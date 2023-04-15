package com.boot.Curdproject.curdProject.service;

import com.boot.Curdproject.curdProject.dtos.CategoryDto;

import java.util.List;
import java.util.Locale;

public interface categoryService {

    //create

    CategoryDto create(CategoryDto categoryDto);

    //update
    CategoryDto update(CategoryDto categoryDto,String categoryId);
    //delete
    void delete(String categoryId);
    //get all
    List<CategoryDto> getAll();
    //get single category detail
    CategoryDto getSingleById(String categoryId);

}

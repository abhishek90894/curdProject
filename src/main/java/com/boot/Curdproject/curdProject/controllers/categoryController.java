package com.boot.Curdproject.curdProject.controllers;

import com.boot.Curdproject.curdProject.dtos.CategoryDto;
import com.boot.Curdproject.curdProject.service.impl.categoryImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@Slf4j
public class categoryController {
    @Autowired
    private categoryImpl categoryService;
      // create
    public ResponseEntity<CategoryDto> create(@RequestBody @Valid  CategoryDto categoryDto)
    {
         CategoryDto  categoryDto1     = categoryService.create(categoryDto);
         return  new ResponseEntity<CategoryDto>(categoryDto1, HttpStatus.CREATED);
    }

      // update

      // delete

      // get all

     // get single


}

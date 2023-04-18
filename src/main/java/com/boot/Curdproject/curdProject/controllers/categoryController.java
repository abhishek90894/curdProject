package com.boot.Curdproject.curdProject.controllers;

import com.boot.Curdproject.curdProject.dtos.ApiResponseMessage;
import com.boot.Curdproject.curdProject.dtos.CategoryDto;
import com.boot.Curdproject.curdProject.service.categoryService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@Slf4j
public class categoryController {
    @Autowired
    private categoryService categoryService;

    // create
    @PostMapping
    public ResponseEntity<CategoryDto> create(@RequestBody @Valid CategoryDto categoryDto) {
        CategoryDto categoryDto1 = categoryService.create(categoryDto);
        return new ResponseEntity<CategoryDto>(categoryDto1, HttpStatus.OK);
    }

    // update
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> update(@RequestBody @Valid CategoryDto categoryDto, @PathVariable String categoryId) {
        CategoryDto CategoryDto = categoryService.update(categoryDto, categoryId);
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);

    }

    // delete
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponseMessage> delete(@PathVariable String categoryId) {
        categoryService.delete(categoryId);
        ApiResponseMessage message = ApiResponseMessage.builder().message("category deleted succesfully").success(true).status(HttpStatus.OK).build();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    // get all
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAll() {
        List<CategoryDto> categoryDtos = categoryService.getAll();
        return new ResponseEntity<>(categoryDtos, HttpStatus.OK);
    }

    // get single
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getById(@PathVariable String categoryId) {
        CategoryDto categoryDto = categoryService.getSingleById(categoryId);
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

}

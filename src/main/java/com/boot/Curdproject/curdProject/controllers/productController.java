package com.boot.Curdproject.curdProject.controllers;

import com.boot.Curdproject.curdProject.dtos.ApiResponseMessage;
import com.boot.Curdproject.curdProject.dtos.ProductDto;
import com.boot.Curdproject.curdProject.entities.Product;
import com.boot.Curdproject.curdProject.service.productService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class productController {
    @Autowired
    private  productService productService;
    @Autowired
    private ModelMapper mapper;

    //create
    @PostMapping("/create")
    public ResponseEntity<ProductDto> create(@RequestBody @Valid ProductDto productDto)
    {

        ProductDto productDtoCreate = productService.create(productDto);
        return  new ResponseEntity<>(productDtoCreate, HttpStatus.CREATED);
    }

    //update
    @PutMapping("/updated/{id}")
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto productDto,@PathVariable  String id)
    {
        ProductDto productDtoUpdated = productService.update(productDto,id);
        return new ResponseEntity<>(productDtoUpdated,HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/deleted/{id}")
    public ResponseEntity<ApiResponseMessage> delete (@PathVariable String id)
    {
        productService.delete(id);
        ApiResponseMessage message = ApiResponseMessage.builder()
                .message("product deleted")
                .success(true)
                .status(HttpStatus.OK)
                .build();
        return  new ResponseEntity<>(message,HttpStatus.OK);
    }

    //getById
    @GetMapping("/getById/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable String id)
    {
        ProductDto productDto = productService.getProductById(id);
        return new ResponseEntity<>(productDto,HttpStatus.OK);
    }

    //get all
    @GetMapping("/getAll")
    public ResponseEntity<List<ProductDto>> getAll()
    {
        List<ProductDto> productDtos = productService.getAll();
        return  new ResponseEntity<>(productDtos,HttpStatus.OK);
    }

    //get live
    @GetMapping("/getLive")
    public ResponseEntity<List<ProductDto>> getAllLive()
    {
        List<ProductDto> productDtos = productService.getAllLive();
        return new ResponseEntity<>(productDtos,HttpStatus.OK);
    }

    //get ByTitle
    @GetMapping("/getByTitle/{title}")
    public ResponseEntity<List<ProductDto>> getByTitle(@PathVariable String title)
    {
        List<ProductDto> productDtos = productService.searchByTitle(title);
        return  new ResponseEntity<>(productDtos,HttpStatus.OK);
    }

    //upload image


    //serve image
}

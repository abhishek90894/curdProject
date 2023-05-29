package com.boot.Curdproject.curdProject.service;

import com.boot.Curdproject.curdProject.dtos.ProductDto;
import com.boot.Curdproject.curdProject.entities.Product;

import java.util.List;

public interface productService {

    //create method

     ProductDto create(ProductDto productDto);

     //update product
     ProductDto update(ProductDto productDto,String productId);

     //delete method
    void delete(String productId);

    //get singleProduct

    ProductDto getProductById(String productId);

    //get all product
    List<ProductDto> getAll();




    //get all live
     List<ProductDto> getAllLive();

     //search prodcut

    List<ProductDto> searchByTitle(String title);


}

package com.boot.Curdproject.curdProject.services;

import com.boot.Curdproject.curdProject.dtos.ProductDto;
import com.boot.Curdproject.curdProject.entities.Product;
import com.boot.Curdproject.curdProject.entities.user;
import com.boot.Curdproject.curdProject.exception.ResourceNotFoundException;
import com.boot.Curdproject.curdProject.repository.productRepository;
import com.boot.Curdproject.curdProject.service.impl.productServiceImpl;
import com.boot.Curdproject.curdProject.service.productService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.Optional;

import static org.mockito.Mockito.*;

@Slf4j
@SpringBootTest
public class productServiceTest {

    @MockBean
    private productRepository productRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private productService productService  ;

    private Product product;


    @BeforeEach
    void init() {
           product = Product.builder()
                  .price(38000)
                  .stock(true)
                  .live(true)
                  .addedDate(new Date())
                  .discountedPrice(32000)
                  .quantity(500)
                  .title("lg")
                  .description("best quality product")
                  .build();
    }
    @Test
    public void createProduct()
    {
        when(productRepository.save(Mockito.any())).thenReturn(product);
        ProductDto productDto = mapper.map(product, ProductDto.class);
        ProductDto productDto1 = productService.create(productDto);
        Assertions.assertEquals(productDto.getPrice(),product.getPrice());

    }

    @Test
    public void updateProduct()
    {
     String id = "abcde12345";
        ProductDto productDto = ProductDto.builder()
                .price(40000)
                .stock(true)
                .live(true)
                .addedDate(new Date())
                .discountedPrice(35000)
                .quantity(1500)
                .title("LG")
                .description("best quality product of LG tv")
                .build();
        when(productRepository.findById(Mockito.anyString())).thenReturn(Optional.of(product));
        product.setAddedDate(productDto.getAddedDate());
        product.setStock(productDto.isStock());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        product.setLive(productDto.isLive());
        product.setDescription(productDto.getDescription());
        product.setDiscountedPrice(productDto.getDiscountedPrice());
        product.setTitle(productDto.getTitle());
        product.setStock(productDto.isLive());
        when(productRepository.save(product)).thenReturn(product);
        ProductDto updateDto = productService.update(productDto,id);

        log.info("updated product {}",updateDto);
        Assertions.assertNotNull(productDto);
        Assertions.assertEquals(productDto.getDescription(),product.getDescription());
    }


    @Test
    public void updateProductNotfoundTest()
    {
        String id = "abcde12345";
        ProductDto productDto = ProductDto.builder()
                .price(40000)
                .stock(true)
                .live(true)
                .addedDate(new Date())
                .discountedPrice(35000)
                .quantity(1500)
                .title("LG")
                .description("best quality product of LG tv")
                .build();
        when(productRepository.findById(Mockito.anyString())).thenReturn(Optional.empty());
        product.setAddedDate(productDto.getAddedDate());
        product.setStock(productDto.isStock());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        product.setLive(productDto.isLive());
        product.setDescription(productDto.getDescription());
        product.setDiscountedPrice(productDto.getDiscountedPrice());
        product.setTitle(productDto.getTitle());
        product.setStock(productDto.isLive());
        when(productRepository.save(product)).thenReturn(product);
        try {
            ProductDto updateDto = productService.update(productDto, id);
        }
        catch (Exception ex)
        {
            Assertions.assertTrue(ex instanceof ResourceNotFoundException);
            Assertions.assertEquals("product not found",ex.getMessage());
            verify(productRepository,times(1)).findById(id);
            verify(productRepository,times(0)).save(any());
        }

    }

    @Test
    void deleteProductTest()
    {
        String productId = "abc12345";
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        productService.delete(productId);
        verify(productRepository,times(1)).delete(product);

    }

    @Test
    void deleteProductNotFoundTest()
    {
        String productId = "abc12345";
        when(productRepository.findById(productId)).thenReturn(Optional.empty());
        try {
            productService.delete(productId);
        }
        catch (Exception ex)
        {
            Assertions.assertTrue(ex instanceof ResourceNotFoundException);
            Assertions.assertEquals("product not found",ex.getMessage());
            Mockito.verify(productRepository,times(0)).delete(product);
            Mockito.verify(productRepository,never()).delete(any());
        }

    }




}

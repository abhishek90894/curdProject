package com.boot.Curdproject.curdProject.controllers;

import com.boot.Curdproject.curdProject.dtos.ProductDto;
import com.boot.Curdproject.curdProject.entities.Product;
import com.boot.Curdproject.curdProject.service.productService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerUnitTest {

    private Product product;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private productService productService;
    @Autowired
    private ModelMapper modelMapper;

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
    @DisplayName("product created test case")
    void createProductTest() throws Exception {
        //   /users  +POST + send user data as a json
        //  data as a json and status we get is created
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        when(productService.create(Mockito.any())).thenReturn(productDto);


        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/product/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonString(productDto));

        ResultActions perform = mockMvc.perform(requestBuilder);
        MvcResult andReturn = perform.andReturn();
        MockHttpServletResponse response = andReturn.getResponse();
        int status = response.getStatus();
        assertEquals(201, status);
    }

    @Test
    @DisplayName("update product created test case")
    void updateProductTest() throws Exception {
        //   /users  +POST + send user data as a json
        //  data as a json and status we get is created
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        String id = "abc12345";
        when(productService.update(Mockito.any(), Mockito.anyString())).thenReturn(productDto);


        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/product/updated/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonString(productDto));

        ResultActions perform = mockMvc.perform(requestBuilder);
        MvcResult andReturn = perform.andReturn();
        MockHttpServletResponse response = andReturn.getResponse();
        int status = response.getStatus();
        assertEquals(200, status);
    }

    @Test
    @DisplayName("delete product created test case")
    void deleteProductTest() throws Exception {
        //   /users  +POST + send user data as a json
        //  data as a json and status we get is created
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        String id = "abc12345";
        productService.delete(id);


        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/product/deleted/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonString(productDto));

        ResultActions perform = mockMvc.perform(requestBuilder);
        MvcResult andReturn = perform.andReturn();
        MockHttpServletResponse response = andReturn.getResponse();
        int status = response.getStatus();
        assertEquals(200, status);
    }

    @Test
    void getProductByIdTest() throws Exception {
        String userId = "abc12345678";

        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        Mockito.when(productService.getProductById(Mockito.anyString())).thenReturn(productDto);

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/product/getById/" + userId); // use to create request
        ResultActions perform = mockMvc.perform(mockHttpServletRequestBuilder); // use to send the request
        MvcResult mvcResult = perform.andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        int status = response.getStatus();
        assertEquals(200, status);


    }

    @Test
    void getAllProductTest() throws Exception {

        ProductDto product = ProductDto.builder()
                .price(38000)
                .stock(true)
                .live(true)
                .addedDate(new Date())
                .discountedPrice(32000)
                .quantity(500)
                .title("samsung")
                .description("best quality product")
                .build();

        ProductDto product1 = ProductDto.builder()
                .price(48000)
                .stock(true)
                .live(true)
                .addedDate(new Date())
                .discountedPrice(32000)
                .quantity(500)
                .title("lg")
                .description("best quality product")
                .build();

        List<ProductDto> productDtoList = Arrays.asList(product1, product);
        String userId = "abc12345678";

        ProductDto productDto = modelMapper.map(product, ProductDto.class);

        Mockito.when(productService.getAll()).thenReturn(productDtoList);

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/product/getAll"); // use to create request
        ResultActions perform = mockMvc.perform(mockHttpServletRequestBuilder); // use to send the request
        MvcResult mvcResult = perform.andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        int status = response.getStatus();
        assertEquals(200, status);


    }

    @Test
    void getAllLiveProductTest() throws Exception {

        ProductDto product = ProductDto.builder()
                .price(38000)
                .stock(true)
                .live(true)
                .addedDate(new Date())
                .discountedPrice(32000)
                .quantity(500)
                .title("samsung")
                .description("best quality product")
                .build();

        ProductDto product1 = ProductDto.builder()
                .price(48000)
                .stock(true)
                .live(true)
                .addedDate(new Date())
                .discountedPrice(32000)
                .quantity(500)
                .title("lg")
                .description("best quality product")
                .build();

        List<ProductDto> productDtoList = Arrays.asList(product1, product);
        String userId = "abc12345678";

        ProductDto productDto = modelMapper.map(product, ProductDto.class);

        Mockito.when(productService.getAllLive()).thenReturn(productDtoList);

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/product/getLive"); // use to create request
        ResultActions perform = mockMvc.perform(mockHttpServletRequestBuilder); // use to send the request
        MvcResult mvcResult = perform.andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        int status = response.getStatus();
        assertEquals(200, status);


    }

    @Test
    void getProductByTitleTest() throws Exception {
        String title = "samsung";

        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        Mockito.when(productService.getProductById(Mockito.anyString())).thenReturn(productDto);

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/product/getByTitle/" + title); // use to create request
        ResultActions perform = mockMvc.perform(mockHttpServletRequestBuilder); // use to send the request
        MvcResult mvcResult = perform.andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        int status = response.getStatus();
        assertEquals(200, status);


    }


    private String convertObjectToJsonString(Object product) {

        try {
            return new ObjectMapper().writeValueAsString(product);
        } catch (Exception e) {
            return null;
        }
    }
}

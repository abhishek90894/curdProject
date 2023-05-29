package com.boot.Curdproject.curdProject.service.impl;

import com.boot.Curdproject.curdProject.dtos.ProductDto;
import com.boot.Curdproject.curdProject.entities.Product;
import com.boot.Curdproject.curdProject.exception.ResourceNotFoundException;
import com.boot.Curdproject.curdProject.repository.productRepository;
import com.boot.Curdproject.curdProject.service.productService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class productServiceImpl implements productService {
    @Autowired
   private productRepository productRepository;

    @Autowired
    private ModelMapper mapper;
    @Override
    public ProductDto create(ProductDto productDto) {

           String id = UUID.randomUUID().toString();
      Product product   = mapper.map(productDto, Product.class);
              product.setProductId(id);
         Product saveProduct =  productRepository.save(product);

      return mapper.map(saveProduct, ProductDto.class);
    }

    @Override
    public ProductDto update(ProductDto productDto, String productId) {
        Product product = productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("product not found"));
        product.setDescription(productDto.getDescription());
        product.setLive(productDto.isLive());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.isStock());
        product.setQuantity(productDto.getQuantity());
        product.setPrice(productDto.getPrice());
        product.setDiscountedPrice(productDto.getDiscountedPrice());
        product.setAddedDate(productDto.getAddedDate());
        Product updateProduct  = productRepository.save(product);

        ProductDto productDto1 = mapper.map(updateProduct, ProductDto.class);



        return productDto1;
    }

    @Override
    public void delete(String productId) {
        Product product = productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("product not found"));
          productRepository.delete(product);

    }

    @Override
    public ProductDto getProductById(String productId) {

        Product product = productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("product not found"));

        return mapper.map(product, ProductDto.class);
    }

    @Override
    public List<ProductDto> getAll() {

        List<Product> products = productRepository.findAll();
     List<ProductDto> productDtos = products.stream().map(product -> mapper.map(product, ProductDto.class)).collect(Collectors.toList());
        return productDtos;
    }

    @Override
    public List<ProductDto> getAllLive() {

        List<Product> products = productRepository.findByLiveTrue();
        List<ProductDto> productDtos = products.stream().map(product -> mapper.map(product, ProductDto.class)).collect(Collectors.toList());
        return productDtos;
    }

    @Override
    public List<ProductDto> searchByTitle(String title) {
        List<Product> products = productRepository.findByTitleContaining(title);
        List<ProductDto> productDtos = products.stream().map(product -> mapper.map(product, ProductDto.class)).collect(Collectors.toList());
        return productDtos;
    }
}

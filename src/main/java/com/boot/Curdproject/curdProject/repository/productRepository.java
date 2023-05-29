package com.boot.Curdproject.curdProject.repository;

import com.boot.Curdproject.curdProject.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface productRepository extends JpaRepository<Product,String> {

    //search
    List<Product> findByTitleContaining(String title);

    List<Product> findByLiveTrue();
}

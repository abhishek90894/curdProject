package com.boot.Curdproject.curdProject.repository;

import com.boot.Curdproject.curdProject.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface productRepository extends JpaRepository<Product,String> {

    //search
    List<Product> findByTitleContaining(String title);
    @Query("SELECT p FROM Product p WHERE p.live = 1")
    List<Product> findByLiveTrue();
}

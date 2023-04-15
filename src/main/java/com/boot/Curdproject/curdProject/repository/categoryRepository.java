package com.boot.Curdproject.curdProject.repository;

import com.boot.Curdproject.curdProject.dtos.CategoryDto;
import com.boot.Curdproject.curdProject.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface categoryRepository extends JpaRepository<Category,String> {


}

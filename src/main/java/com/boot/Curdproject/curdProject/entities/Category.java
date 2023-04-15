package com.boot.Curdproject.curdProject.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Entity
public class Category {
     @Column(name ="categoryId")
    private String categoryId;
     @Column(name ="title",length = 100,nullable = false)
    private String title;
     @Column(name ="description",length =200)
    private String description;
    private String coverImage;

}

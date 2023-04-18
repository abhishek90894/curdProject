package com.boot.Curdproject.curdProject.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Entity
public class Category {
    @Id
    @Column(name = "categoryId")
    private String categoryId;

    private String title;

    private String description;
    private String coverImage;

}

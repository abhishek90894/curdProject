package com.boot.Curdproject.curdProject.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {

    private String productId;

    private String title;
    @Column(length = 1000)
    private String description;

    private double price;
    private double discountedPrice;

    private int quantity;
    private Date addedDate;
    private boolean live;
    private boolean stock;
}

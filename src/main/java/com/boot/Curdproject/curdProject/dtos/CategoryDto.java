package com.boot.Curdproject.curdProject.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class CategoryDto {


    private String categoryId;
    @NotBlank
    @Min(value = 5,message = "title should be minimum of 5")
    private String title;
    @NotBlank(message = "description is required")
    private String description;
    @NotBlank(message = "coverImage should be required")
    private String coverImage;
}

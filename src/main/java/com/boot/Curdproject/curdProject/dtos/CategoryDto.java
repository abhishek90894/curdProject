package com.boot.Curdproject.curdProject.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
public class CategoryDto {


    private String categoryId;
    @NotBlank
    @Size(min = 4,max = 100,message = "title should be between 4 and 100")
    private String title;
    @NotBlank(message = "description is required")
    private String description;
    @NotBlank(message = "coverImage should be required")
    private String coverImage;
}

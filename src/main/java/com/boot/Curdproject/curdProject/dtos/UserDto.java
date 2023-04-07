package com.boot.Curdproject.curdProject.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDto {



    private String userId;
   @Size(min = 3,max = 15 , message = "Invalid name")
    private String userName;
    @Email(message = "Invalid email")
// @Pattern(regexp = "\\A[A-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[A-Z0-9.-]+\\Z",message = "Invalid user Email !!")
    private String Email;
    @NotBlank(message = "password is required")
    private String Password;
    @Size(min =4,max=9)
    private String gender;
    @NotBlank(message = "about is required")
    private String about;

    private String imageName;

}

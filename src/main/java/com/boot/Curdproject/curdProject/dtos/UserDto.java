package com.boot.Curdproject.curdProject.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {



    private String userId;

    private String userName;

    private String userEmail;
    private String userPassword;
    private String gender;

    private String about;
    private String imageName;
}

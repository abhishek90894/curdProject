package com.boot.Curdproject.curdProject.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {



    private String userId;

    private String userName;

    private String Email;
    private String Password;
    private String gender;

    private String about;
    private String imageName;
}

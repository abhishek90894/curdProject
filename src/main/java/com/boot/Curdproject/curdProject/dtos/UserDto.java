package com.boot.Curdproject.curdProject.dtos;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDto {



    private String userId;

    private String userName;

    private String Email;
    private String Password;
    private String gender;

    private String about;
    private String imageName;
}

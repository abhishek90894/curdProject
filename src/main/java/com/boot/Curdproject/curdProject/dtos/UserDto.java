package com.boot.Curdproject.curdProject.dtos;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
=======
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
>>>>>>> project
public class UserDto {



    private String userId;

    private String userName;

    private String Email;
    private String Password;
    private String gender;

    private String about;
    private String imageName;
}

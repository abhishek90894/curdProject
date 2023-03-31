package com.boot.Curdproject.curdProject.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class user  {

    @Id
    private String userId;
    @NotNull
    private String userName;
    //@Column(unique = true)
    @Email
    private String userEmail;
    @Max(value = 12)
    @Min(value = 6)
    private String Password;
    @Min(4)
    @Max(10)
    private String gender;
    @NotBlank
    @Column(length =100)
    private String about;
    @NotNull
    private String imageName;

}

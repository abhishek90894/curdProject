package com.boot.Curdproject.curdProject.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    private String userName;
    //@Column(unique = true)
    private String userEmail;
    private String Password;
    private String gender;
    @Column(length =100)
    private String about;
    private String imageName;

}

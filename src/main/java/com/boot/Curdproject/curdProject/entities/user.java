package com.boot.Curdproject.curdProject.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class user {

    @Id

    private String userId;

    private String userName;
    @Column(unique = true)
    private String Email;
    private String Password;
    private String gender;
    @Column(length =100)
    private String about;
    private String imageName;
}

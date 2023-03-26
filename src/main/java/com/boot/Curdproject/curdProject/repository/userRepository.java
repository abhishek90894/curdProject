package com.boot.Curdproject.curdProject.repository;

import com.boot.Curdproject.curdProject.entities.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<user,String> {

    user findByEmail(String email);
    user findByEmailAndPassword(String email , String password);

}

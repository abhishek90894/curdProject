package com.boot.Curdproject.curdProject.repository;

import com.boot.Curdproject.curdProject.entities.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface userRepository extends JpaRepository<user,String> {

 Optional<user> findByEmail(String email);
   Optional<user> findByEmailAndPassword(String email , String password);
  List<user> findByNameContaining(String keywords);

}

package com.boot.Curdproject.curdProject.repository;

import com.boot.Curdproject.curdProject.entities.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Component
public interface userRepository extends JpaRepository<user,String> {
//      user findByuserEmail(String email);

//    Optional<Object> findByUserName(String username);
//
      @Query(value = "SELECT u FROM user u WHERE Email = ?1")
      user findByEmail(String email);


 //   Optional<user> findByEmailAndPassword(String email , String password);
//  List<user> findByNameContaining(String keywords);

}

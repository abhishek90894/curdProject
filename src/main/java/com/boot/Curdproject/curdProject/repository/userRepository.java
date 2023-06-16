package com.boot.Curdproject.curdProject.repository;

import com.boot.Curdproject.curdProject.entities.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<user,String> {
//      user findByuserEmail(String email);
//   Optional<user> findByEmail(String email);

//    Optional<Object> findByUserName(String username);

      


 //   Optional<user> findByEmailAndPassword(String email , String password);
//  List<user> findByNameContaining(String keywords);

}

package com.ftn.bsep.repository;

import com.ftn.bsep.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findUserByEmail(@Param("email")String email);

    @Query("SELECT u FROM User u WHERE u.id = :id")
    User findUserById(@Param("id") Long id);

    @Query(value = "SELECT * FROM User", nativeQuery = true)
    List<User> findAll();

 //   @Modifying
  // @Query(value = "insert into User (name, last_name, email, password, last_password_reset_date, enabled) values (:name, :last_name, :email, :password, :last_passwort_reset_date, :enabled)",
    //        nativeQuery = true)
   //void saveUser(@Param("name")String name, @Param("last_name") String lastName, @Param("email") String email,@Param("password")  String password,@Param("last_password_reset_date") Timestamp lastPasswordResetDate, @Param("enabled") boolean enabled);

}

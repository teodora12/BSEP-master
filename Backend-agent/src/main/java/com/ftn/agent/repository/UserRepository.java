package com.ftn.agent.repository;

import com.ftn.agent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  //  User findUserByUsername(String username);
    User findUserByEmail(String email);
    User findUserById(Long id);
}

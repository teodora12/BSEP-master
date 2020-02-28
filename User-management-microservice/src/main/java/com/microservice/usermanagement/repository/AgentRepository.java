package com.microservice.usermanagement.repository;

import com.microservice.usermanagement.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentRepository extends JpaRepository<Agent,Long> {

    Agent findAgentById(Long id);
    Agent findAgentByEmail(String email);
    List<Agent> findAll();
}

package com.ftn.agent.repository;

import com.ftn.agent.model.forDatabase.AgentForDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<AgentForDatabase, Long> {
    AgentForDatabase findAgentForDatabaseById(String username);
    AgentForDatabase findAgentForDatabaseByEmail(String email);
}

package com.ftn.bsep.repository;

import com.ftn.bsep.model.modelGenerated.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentRepository  extends JpaRepository<Agent,Long > {

    Agent findAgentByUsername(String username);

    @Query(value = "select a.* from agent a " +
            "left join accommodation_agent aa on a.id = aa.agent_id where aa.accommodation_id = :id", nativeQuery = true)
    List<Agent> findAgentsByAccommodation(@Param("id") Long id);
}

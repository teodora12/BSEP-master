package com.ftn.agent.repository;

import com.ftn.agent.model.Message;
import com.ftn.agent.model.forDatabase.MessageForDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<MessageForDatabase, Long> {

    ArrayList<MessageForDatabase> findMessageByAgent_Id(Long id);
    ArrayList<MessageForDatabase> findMessageByUser_Id(Long id);
    List<MessageForDatabase> findMessagesByAgent_Username(String username);

}

package com.ftn.bsep.repository;

import com.ftn.bsep.model.MessageForDatabase;
import com.ftn.bsep.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<MessageForDatabase,Long > {

    List<MessageForDatabase> findMessageByAgent_Id(Long id);
    List<MessageForDatabase> findMessageForDatabasesByUser(User user);
    List<MessageForDatabase> findMessageByUser_Id(Long id);
}

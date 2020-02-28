package com.ftn.agent.restService;

import com.ftn.agent.dto.CreateMessageDTO;
import com.ftn.agent.model.Message;
import com.ftn.agent.model.forDatabase.MessageForDatabase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {

    List<MessageForDatabase> findAll();
    MessageForDatabase save(MessageForDatabase message);
    List<MessageForDatabase> saveAll(List<MessageForDatabase> messages);
    List<MessageForDatabase> getAllMessages(String username);
    MessageForDatabase sendMessage(CreateMessageDTO messageDTO);

}

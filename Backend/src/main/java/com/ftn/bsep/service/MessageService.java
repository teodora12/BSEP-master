package com.ftn.bsep.service;

import com.ftn.bsep.dto.message.CreateMessageDTO;
import com.ftn.bsep.model.MessageForDatabase;
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

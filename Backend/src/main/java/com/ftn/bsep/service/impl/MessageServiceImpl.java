package com.ftn.bsep.service.impl;

import com.ftn.bsep.dto.message.CreateMessageDTO;
import com.ftn.bsep.model.MessageForDatabase;
import com.ftn.bsep.model.modelGenerated.Agent;
import com.ftn.bsep.model.modelGenerated.User;
import com.ftn.bsep.repository.MessageRepository;
import com.ftn.bsep.repository.UserRepository;
import com.ftn.bsep.security.validation.RegularExpressions;
import com.ftn.bsep.service.AgentService;
import com.ftn.bsep.service.MessageService;
import com.ftn.bsep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AgentService agentService;

    @Override
    public List<MessageForDatabase> findAll() {
        return this.messageRepository.findAll();
    }

    @Override
    public MessageForDatabase save(MessageForDatabase message) {
        return this.messageRepository.save(message);
    }

    @Override
    public List<MessageForDatabase> saveAll(List<MessageForDatabase> messages) {
        return this.messageRepository.saveAll(messages);
    }

    @Override
    public List<MessageForDatabase> getAllMessages(String username) {


        RegularExpressions regularExpressions = new RegularExpressions();
        boolean isUsernameValid = regularExpressions.isEmailValid(username);

        if(isUsernameValid == false){
            return null;
        }

        com.ftn.bsep.model.User userForDatabase = this.userService.findUserByMail(username);

        List<MessageForDatabase> msgsForDatabse = this.messageRepository.findMessageByUser_Id(userForDatabase.getId());

        if(msgsForDatabse == null){
            return null;
        }

        return msgsForDatabse;
    }

    @Override
    public MessageForDatabase sendMessage(CreateMessageDTO messageDTO) {

        RegularExpressions regularExpressions = new RegularExpressions();

        boolean isUserEmailVali = regularExpressions.isEmailValid(messageDTO.getUserUsername());
        boolean isAgenEmailValid = regularExpressions.isEmailValid(messageDTO.getAgentUsername());

        if(!(isAgenEmailValid || isUserEmailVali)){
            return null;
        }

        MessageForDatabase messageForDatabase = new MessageForDatabase(messageDTO);

        Agent agent = this.agentService.findAgentByUsername(messageDTO.getAgentUsername());
        messageForDatabase.setAgent(agent);

        com.ftn.bsep.model.User userForDatabase = this.userService.findUserByUsername(messageDTO.getUserUsername());
        messageForDatabase.setUser(userForDatabase);

        this.messageRepository.save(messageForDatabase);

        return messageForDatabase;
    }
}

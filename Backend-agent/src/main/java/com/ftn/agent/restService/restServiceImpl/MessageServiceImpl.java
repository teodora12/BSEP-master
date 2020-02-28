package com.ftn.agent.restService.restServiceImpl;

import com.ftn.agent.dto.CreateMessageDTO;
import com.ftn.agent.model.*;
import com.ftn.agent.model.forDatabase.AgentForDatabase;
import com.ftn.agent.model.forDatabase.MessageForDatabase;
import com.ftn.agent.repository.MessageRepository;
import com.ftn.agent.restService.AddressService;
import com.ftn.agent.restService.AgentService;
import com.ftn.agent.restService.MessageService;
import com.ftn.agent.restService.UserService;
import com.ftn.agent.security.validation.RegularExpressions;
import com.ftn.agent.soapService.SOAPConnectorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private SOAPConnectorMessage soapConnectorMessage;

    @Autowired
    private AgentService agentService;

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @Override
    public List<MessageForDatabase> findAll()
    {
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

        GetMessagesResponse response = this.soapConnectorMessage.getMessageResponse(username);


        if(response == null || response.getMessage() == null){
            return  null;
        }

        List<Message> messages = response.getMessage();

        //   List<Message> allAgentMessages = this.messageRepository.findMessagesByAgent_Username(username);
        List<MessageForDatabase> allAgentMessages = this.messageRepository.findMessagesByAgent_Username(username);

        allAgentMessages.removeAll(allAgentMessages);


    //    Agent agent = this.agentService.findAgentByUsername(username);
        AgentForDatabase agent = this.agentService.findAgentByUsername(username);

        List<MessageForDatabase> newMessages = new ArrayList<>();
        for(Message m: messages){
            MessageForDatabase message = new MessageForDatabase(m);
            message.setAgent(agent);

            User userDatabse = this.userService.findUserByEmail(m.getUser().getUsername());
            if(userDatabse == null){
                User newUser = new User(m.getUser());
                message.setUser(newUser);
                this.userService.save(newUser);
            }else {
                message.setUser(userDatabse);
            }

            newMessages.add(message);
        }


        this.messageRepository.saveAll(newMessages);

        return newMessages;
    }

    @Override
    public MessageForDatabase sendMessage(CreateMessageDTO messageDTO) {

        RegularExpressions regularExpressions = new RegularExpressions();


        MessageForDatabase messageForDatabase = new MessageForDatabase(messageDTO);
        AgentForDatabase agentForDatabase = this.agentService.findAgentByUsername(messageDTO.getAgentUsername());
        messageForDatabase.setAgent(agentForDatabase);

        //ovaj user ovde mora biti sa ove strane u importu jer hoce njemu da posalje poruku pa ga trazi u ovoj bazi
        User user = this.userService.findUserByEmail(messageDTO.getUserUsername());
        if(user == null){
            return  null;
        }
        messageForDatabase.setUser(user);
        Agent agent  = new Agent(agentForDatabase);
        Message message = new Message(messageForDatabase);
        message.setAgent(agent);

        SendMessageResponse response = this.soapConnectorMessage.sendMessageResponse(message);

        if(response.isSuccess() == false){
            return  null;
        }

        this.messageRepository.save(messageForDatabase);


        return messageForDatabase;
    }
}

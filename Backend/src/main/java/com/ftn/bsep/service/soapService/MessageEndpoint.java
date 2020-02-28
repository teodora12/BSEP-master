package com.ftn.bsep.service.soapService;

import com.ftn.bsep.model.MessageForDatabase;
import com.ftn.bsep.model.modelGenerated.*;
import com.ftn.bsep.repository.AgentRepository;
import com.ftn.bsep.repository.MessageRepository;
import com.ftn.bsep.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Endpoint
public class MessageEndpoint {

    private static final String NAMESPACE_URI = "http://www.ftn.uns.ac.rs/message";

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private AgentRepository agentRepository;


    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    public MessageEndpoint(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetMessagesRequest")
    @ResponsePayload
    public GetMessagesResponse getMessages(@RequestPayload GetMessagesRequest request) {

        Agent agent = agentRepository.findAgentByUsername(request.getUsername());
        List<MessageForDatabase> messages = messageRepository.findMessageByAgent_Id(agent.getId());

        List<Message> xmlMessages = new ArrayList<>();
        for (MessageForDatabase m : messages) {
            xmlMessages.add(new Message(m.getAgent(), new User(m.getUser()), m.getDateOfSending(), m.getContent(), m.getSubject()));

        }

        GetMessagesResponse response = new GetMessagesResponse();
        response.getMessage().addAll(xmlMessages);

        return response;
    }



    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SendMessageRequest")
    @ResponsePayload
    public SendMessageResponse sendMessage(@RequestPayload SendMessageRequest request) {

        Message messageRequest = request.getMessage();
        MessageForDatabase msgDatabase = new MessageForDatabase(messageRequest);

 //       User user = messageRequest.getUser();
      //  com.ftn.bsep.model.User userForDatabase = new com.ftn.bsep.model.User(user);

        //moraju biti u importu i user i agent
        com.ftn.bsep.model.User user1 = this.userRepository.findUserByEmail(messageRequest.getUser().getEmail());
        Agent agent1 = this.agentRepository.findAgentByUsername(messageRequest.getAgent().getUsername());

        msgDatabase.setAgent(agent1);
        msgDatabase.setUser(user1);

        this.messageRepository.save(msgDatabase);

        SendMessageResponse response = new SendMessageResponse();
        response.setSuccess(true);

        return response;
    }

}

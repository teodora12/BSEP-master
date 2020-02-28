package com.ftn.bsep.model;

import com.ftn.bsep.dto.message.CreateMessageDTO;
import com.ftn.bsep.model.modelGenerated.Message;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "message")
@Data
@Slf4j
public class MessageForDatabase {


        @Id
        @Column(name="id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column
        private Date dateOfSending;

        @Column
        private String subject;

        @Column
        private String content;


        @ManyToOne
        private User user;

        @ManyToOne
        private com.ftn.bsep.model.modelGenerated.Agent agent;


        public MessageForDatabase() {};


        public MessageForDatabase(CreateMessageDTO messageDTO){
            this.content = messageDTO.getContent();
            this.subject = messageDTO.getSubject();

//            try{
//                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                this.dateOfSending  =  dateFormat.parse(messageDTO.getDateOfSending());
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }

            Date today = new Date();
            this.dateOfSending = today;
        }

        public MessageForDatabase(Message message){
            this.agent = message.getAgent();
            this.content = message.getContent();
            this.subject = message.getSubject();
            this.dateOfSending = message.getDateOfSending();
        }

        public MessageForDatabase(Message xmlMessage, User user) {
            this.agent = xmlMessage.getAgent();
            this.user = user;
            this.content = xmlMessage.getContent();
            this.subject = xmlMessage.getSubject();
            this.dateOfSending = xmlMessage.getDateOfSending();
        }


        }


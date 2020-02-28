package com.ftn.bsep.config;

import com.ftn.bsep.EventHendler;
import com.ftn.bsep.model.modelGenerated.Accommodation;
import com.ftn.bsep.model.modelGenerated.Address;
import com.ftn.bsep.model.modelGenerated.Message;
import com.ftn.bsep.model.modelGenerated.User;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {


//    @Bean
//    public SaajSoapMessageFactory messageFactory() {
//        SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
//        messageFactory.setSoapVersion(SoapVersion.SOAP_12);
//        return messageFactory;
//    }

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }


    @Bean(name = "addresses")
    public DefaultWsdl11Definition defaultWsdl(XsdSchema addressesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("AddressesPort");
        wsdl11Definition.setLocationUri("/ws/address");
        wsdl11Definition.setCreateSoap12Binding(true);
        wsdl11Definition.setTargetNamespace("http://www.ftn.uns.ac.rs/address");
        wsdl11Definition.setSchema(addressesSchema);
        return wsdl11Definition;
    }

    @Bean(name = "users")
    public DefaultWsdl11Definition defaultWsdl11(XsdSchema usersSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("UsersPort");
        wsdl11Definition.setCreateSoap12Binding(true);
        wsdl11Definition.setLocationUri("/ws/user");
        wsdl11Definition.setTargetNamespace("http://www.ftn.uns.ac.rs/user");
        wsdl11Definition.setSchema(usersSchema);
        return wsdl11Definition;
    }
    @Bean(name = "accommodations")
    public DefaultWsdl11Definition defaultWsdl1(XsdSchema accommodationsSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setCreateSoap12Binding(true);
        wsdl11Definition.setPortTypeName("AccommodationPort");
        wsdl11Definition.setLocationUri("/ws/accommodation");
        wsdl11Definition.setTargetNamespace("http://www.ftn.uns.ac.rs/accommodation");
        wsdl11Definition.setSchema(accommodationsSchema);
        return wsdl11Definition;
    }

    @Bean(name = "messages")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema messagesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setCreateSoap12Binding(true);
        wsdl11Definition.setPortTypeName("MessagePort");
        wsdl11Definition.setLocationUri("/ws/message");
        wsdl11Definition.setTargetNamespace("http://www.ftn.uns.ac.rs/message");
        wsdl11Definition.setSchema(messagesSchema);
        return wsdl11Definition;
    }


    @Bean
    public XsdSchema addressesSchema() {

        try {
            InputStream inputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/address.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Address.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Address address = (Address) jaxbUnmarshaller.unmarshal(inputStream);
            jaxbUnmarshaller.setEventHandler( new EventHendler());
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }

        return new SimpleXsdSchema(new ClassPathResource("Address.xsd"));
    }

    @Bean
    public XsdSchema accommodationsSchema() {

        try {
            InputStream inputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/accommodation.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Accommodation.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Accommodation accommodation = (Accommodation) jaxbUnmarshaller.unmarshal(inputStream);
            jaxbUnmarshaller.setEventHandler( new EventHendler());
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }

        return new SimpleXsdSchema(new ClassPathResource("Accommodation.xsd"));
    }


    @Bean
    public XsdSchema usersSchema() {

        try {
            InputStream inputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/user.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            User user = (User) jaxbUnmarshaller.unmarshal(inputStream);
            jaxbUnmarshaller.setEventHandler( new EventHendler());
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }

        return new SimpleXsdSchema(new ClassPathResource("User.xsd"));
    }

    @Bean
    public XsdSchema messagesSchema() {


        try {
            InputStream inputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/message.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Message message = (Message) jaxbUnmarshaller.unmarshal(inputStream);
            jaxbUnmarshaller.setEventHandler( new EventHendler());
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }

        return new SimpleXsdSchema(new ClassPathResource("Message.xsd"));
    }



}

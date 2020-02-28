FROM anapsix/alpine-java
MAINTAINER Nikolina Stamenic <nikolinastamenic@uns.ac.rs>
ADD target/user-management-0.0.1-SNAPSHOT.jar user-management.jar
ADD keystore.jks keystore.jks
ADD agent.jks agent.jks
ENTRYPOINT ["java", "-jar", "/user-management.jar"]
EXPOSE 8083
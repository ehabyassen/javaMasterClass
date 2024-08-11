package com.example.topic;

import com.sun.messaging.Topic;
import com.sun.messaging.TopicConnectionFactory;

import javax.jms.*;

//https://www.oracle.com/technical-resources/articles/java/intro-java-message-service.html
public class Subscriber {

    public static void main(String[] args) throws Exception {
        TopicConnectionFactory connFactory = new TopicConnectionFactory();
        TopicConnection connection = connFactory.createTopicConnection();
        // This session is not transacted, and it uses automatic message acknowledgement
        TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = new Topic("testTopic");
        TopicSubscriber subscriber = session.createSubscriber(topic);

        connection.start();

        while (true) {
            Message message = subscriber.receive();
            System.out.println("Received message: " + ((TextMessage) message).getText());
        }
    }
}

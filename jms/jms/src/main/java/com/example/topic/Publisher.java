package com.example.topic;

import com.sun.messaging.Topic;
import com.sun.messaging.TopicConnectionFactory;

import javax.jms.*;
import java.util.Random;

//https://www.oracle.com/technical-resources/articles/java/intro-java-message-service.html
public class Publisher {

    public static void main(String[] args) throws Exception {
        TopicConnectionFactory connFactory = new TopicConnectionFactory();
        TopicConnection connection = connFactory.createTopicConnection();
        // This session is not transacted, and it uses automatic message acknowledgement
        TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = new Topic("testTopic");
        TopicPublisher publisher = session.createPublisher(topic);

        int publisherId = new Random().nextInt(10);

        int i = 1;
        while (i < 11) {
            TextMessage message = session.createTextMessage(publisherId + "_message#" + i);
            System.out.println("Sending message: " + message.getText());
            publisher.publish(message);
            i++;
            Thread.sleep(1000);
        }

        session.close();
        connection.close();
    }
}

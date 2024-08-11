package com.example.queue;

import com.sun.messaging.Queue;
import com.sun.messaging.QueueConnectionFactory;

import javax.jms.*;

//https://www.oracle.com/technical-resources/articles/java/intro-java-message-service.html
public class Consumer {

    public static void main(String[] args) throws Exception {
        QueueConnectionFactory connFactory = new QueueConnectionFactory();
        QueueConnection connection = connFactory.createQueueConnection();
        // This session is not transacted, and it uses automatic message acknowledgement
        QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = new Queue("testQueue");
        QueueReceiver receiver = session.createReceiver(queue);

        connection.start();

        while (true) {
            Message message = receiver.receive();
            System.out.println("Received message: " + ((TextMessage) message).getText());
        }
    }
}

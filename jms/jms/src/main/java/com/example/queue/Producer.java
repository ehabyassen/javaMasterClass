package com.example.queue;

import com.sun.messaging.Queue;
import com.sun.messaging.QueueConnectionFactory;

import javax.jms.*;
import java.util.Random;

//https://www.oracle.com/technical-resources/articles/java/intro-java-message-service.html
public class Producer {

    public static void main(String[] args) throws Exception {
        QueueConnectionFactory connFactory = new QueueConnectionFactory();
        QueueConnection connection = connFactory.createQueueConnection();
        // This session is not transacted, and it uses automatic message acknowledgement
        QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = new Queue("testQueue");
        QueueSender sender = session.createSender(queue);

        int producerId = new Random().nextInt(10);

        int i = 1;
        while (i < 11) {
            TextMessage message = session.createTextMessage(producerId + "_message#" + i);
            System.out.println("Sending message: " + message.getText());
            sender.send(message);
            i++;
            Thread.sleep(1000);
        }

        session.close();
        connection.close();
    }
}

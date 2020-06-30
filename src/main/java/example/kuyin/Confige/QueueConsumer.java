package example.kuyin.Confige;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class QueueConsumer {

    @JmsListener(destination = "${myQueue}")
    public void receive(TextMessage textMessage) throws JMSException {
        System.out.println("接收消息：" + textMessage.getText());
    }
}

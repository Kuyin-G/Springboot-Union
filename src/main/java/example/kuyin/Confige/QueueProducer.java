package example.kuyin.Confige;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;



@Component
@EnableJms
public class QueueProducer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public  void produceMessage(String message){
        // 发送的信息
//

        jmsMessagingTemplate.convertAndSend(queue,message);
    }

}

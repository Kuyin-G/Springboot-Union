package example.kuyin.Confige;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.UUID;


@Component
@EnableJms
public class QueueProducer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public  void produceMessage(String message){
        // 发送的信息
        jmsMessagingTemplate.convertAndSend(queue,message);
    }
    // 定时功能：每隔5秒就发送一条信息
    @Scheduled(fixedDelay = 5000)
    public void produceMsgScheduled(){
        String scheduledMsg = "Scheduled Message:"+ UUID.randomUUID().toString().substring(0,6);
        jmsMessagingTemplate.convertAndSend(queue, scheduledMsg);
        System.out.println("正在定时投放");
    }

}

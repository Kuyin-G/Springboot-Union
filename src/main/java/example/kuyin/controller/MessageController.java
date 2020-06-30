package example.kuyin.controller;


import example.kuyin.Confige.QueueProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
public class MessageController {

    @Autowired
    private QueueProducer queueProducer;


    @RequestMapping("send")
    public String sendMsg(){

        try {
            String message = "Send Message：" + UUID.randomUUID().toString().substring(0,6);
            queueProducer.produceMessage(message);
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "FAILURE";
        }

    }
}

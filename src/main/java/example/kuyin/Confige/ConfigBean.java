package example.kuyin.Confige;


import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

import javax.jms.Queue;



@Configuration
@Component
public class ConfigBean {


    @Value("${myQueue}")
    private String queue_name ; // 队列的名称，



    @Bean
    public Queue queue(){
        return new ActiveMQQueue(queue_name);
    }
}

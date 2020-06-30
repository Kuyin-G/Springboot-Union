package test.kuyin.example;


import example.kuyin.ActiveMqMain;
import example.kuyin.Confige.QueueProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = ActiveMqMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestActiveMq {

    @Autowired
    private QueueProducer queueProducer;


    @Test
    public void testSend(){
        queueProducer.produceMessage("hello");
    }


}

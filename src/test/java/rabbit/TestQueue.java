package rabbit;

import com.uncub.rabbitmq.MQProducerImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-rabbit.xml"})


public class TestQueue{
    @Autowired
    private AmqpTemplate amqpTemplate;

    final String queue_key = "test_queue_key";

    @Test
    public void send(){
        Map<String,Object> msg = new HashMap();
        msg.put("data","hello,rabbmitmq!");

        amqpTemplate.convertAndSend(queue_key, "你好！  1-");
    }
}

package com.uncub.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

@Component("queueListenter")
public class QueueListenter implements MessageListener {

    @Override
    public void onMessage(Message msg) {
        try{
//            System.out.print(msg.toString());
            System.out.println(new String(msg.getBody(), Charset.defaultCharset()));

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}

package com.xiaotao.eshop.service.listener;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by 13725 on 2018/4/11.
 */
public class ActiveMQListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            String text = textMessage.getText();
            System.out.println("getMessage" + text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

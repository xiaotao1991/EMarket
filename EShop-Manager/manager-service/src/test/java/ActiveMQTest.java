import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.IOException;

/**
 * Created by 13725 on 2018/4/11.
 */
public class ActiveMQTest {

    @Test
    public void test1() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext-activemq.xml");

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        Destination destination = (Destination) context.getBean("queueDestination");

        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("hello activeMQ message");
            }
        });

        System.in.read();
    }
}

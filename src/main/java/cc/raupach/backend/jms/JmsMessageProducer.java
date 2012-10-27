package cc.raupach.backend.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Oliver Raupach, 28.03.2012
 */
@Component
public class JmsMessageProducer
{
    private static final Logger logger = LoggerFactory.getLogger(JmsMessageProducer.class);

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * Generate JMS message
     */
    public void sendNumberChangedMessage(final String initiatorClientId) throws JMSException
    {
       
        JmsTemplate template = (JmsTemplate) applicationContext.getBean("jmsTopicTemplate");
       
        template.send("cometPush",new MessageCreator()
        {
            public Message createMessage(Session session) throws JMSException
            {
               

                TextMessage message = session.createTextMessage("Hello World...");
                logger.info("Sending message.............");

                return message;
            }
        });
    }

}

   

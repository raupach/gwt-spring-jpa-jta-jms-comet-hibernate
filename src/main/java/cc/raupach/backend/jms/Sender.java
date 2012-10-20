package cc.raupach.backend.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 * @author Oliver Raupach, 20.10.2012
 */
@Component
public class Sender
{

   private static final Logger logger = LoggerFactory.getLogger(Sender.class);
   
   @Autowired
   private JmsTemplate template ;

   /**
    * Generate JMS message
    */

   public void sendTaskChangedMessage(final String initiatorClientId) throws JMSException
   {
       template.send("queue1", new MessageCreator()
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

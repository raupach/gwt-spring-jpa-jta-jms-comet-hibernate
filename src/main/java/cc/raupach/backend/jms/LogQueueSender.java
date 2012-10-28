package cc.raupach.backend.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 * @author Oliver Raupach, 20.10.2012
 */
@Component
public class LogQueueSender
{

   @Autowired
   private JmsTemplate template ;

   /**
    * Generate JMS message
    */
   public void sendLogMessage(final String logStr) throws JMSException
   {
       template.send("logQueue", new MessageCreator()
       {
           public Message createMessage(Session session) throws JMSException
           {
               TextMessage message = session.createTextMessage(logStr);

               return message;
           }
       });
   }
}

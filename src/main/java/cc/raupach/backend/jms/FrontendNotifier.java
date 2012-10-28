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

import com.google.gson.Gson;

/**
 * 
 * @author Oliver Raupach, 28.03.2012
 */
@Component
public class FrontendNotifier
{
   private static final Logger logger = LoggerFactory.getLogger(FrontendNotifier.class);

   @Autowired
   private JmsTemplate jmsTemplate;

   /**
    * Generate JMS message
    */
   public void sendNumberChangedMessage(final int number) throws JMSException
   {

      jmsTemplate.send("cometPush", new MessageCreator()
      {
         public Message createMessage(Session session) throws JMSException
         {
            
            JsonNumberDto dto = new JsonNumberDto(number);
            Gson gson = new Gson();
            String jsonDtoStr = gson.toJson(dto);
            
            TextMessage message = session.createTextMessage(jsonDtoStr);
            logger.info("Sending message............."+jsonDtoStr);

            return message;
         }
      });
   }

}

package cc.raupach.backend.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Oliver Raupach, 20.10.2012
 */
public class Listener2 implements MessageListener
{

   private static final Logger logger = LoggerFactory.getLogger(Listener2.class);
   
   @Override
   public void onMessage(Message message)
   {
      TextMessage textMessage = (TextMessage) message;
      try
      {
         logger.info("Empfangen ................."+textMessage.getText());
      }
      catch (JMSException e)
      {
         e.printStackTrace();
      }
   }

}

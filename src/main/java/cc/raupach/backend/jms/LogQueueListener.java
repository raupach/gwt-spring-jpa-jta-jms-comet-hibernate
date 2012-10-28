package cc.raupach.backend.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Oliver Raupach, 20.10.2012
 */
@Component (value="LogQueueListener")
public class LogQueueListener implements MessageListener
{

   private static final Logger logger = LoggerFactory.getLogger(LogQueueListener.class);

   @Override
   public void onMessage(Message message)
   {
      try
      {
         TextMessage tm = (TextMessage) message;

         logger.info("Receive LogMessage ................." + tm.getText());
      }
      catch (JMSException e)
      {
         logger.error(e.getMessage(), e);
      }
   }

}

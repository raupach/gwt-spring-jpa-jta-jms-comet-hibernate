package cc.raupach.backend.jms;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Oliver Raupach, 20.10.2012
 */
public class Listener implements MessageListener
{

   private static final Logger logger = LoggerFactory.getLogger(Listener.class);
   
   @Override
   public void onMessage(Message message)
   {
      logger.info("Angekommen .................");
   }

}

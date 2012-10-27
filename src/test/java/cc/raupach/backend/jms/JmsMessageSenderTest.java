package cc.raupach.backend.jms;

import javax.jms.JMSException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import cc.raupach.backend.jms.Sender;

/**
 * @author Oliver Raupach, 18.10.2012
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-core.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class JmsMessageSenderTest
{
   private static final Logger logger = LoggerFactory.getLogger(JmsMessageSenderTest.class);
   
   @Autowired
   private Sender sender;
   
   @Test
   public void test() throws JMSException
   {
      sender.sendTaskChangedMessage("abcd");
      
      logger.info("-----------> Abgeschickt.");
     
   }

  
}

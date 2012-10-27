package cc.raupach.backend.jms;


import javax.jms.JMSException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Oliver Raupach, 18.10.2012
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-core.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class JmsMessageProducerTest
{

   @Autowired
   private JmsMessageProducer jmsMessageProducer;
   
   @Test
   public void test() throws JMSException, InterruptedException
   {
      
      
      jmsMessageProducer.sendNumberChangedMessage(1234);
      
      Thread.sleep(200);
   }

  
}

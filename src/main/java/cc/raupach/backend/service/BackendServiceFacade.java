package cc.raupach.backend.service;

import java.util.Date;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.raupach.backend.dao.RequestDAO;
import cc.raupach.backend.dao.SeriesDAO;
import cc.raupach.backend.entity.Request;
import cc.raupach.backend.entity.Series;
import cc.raupach.backend.jms.JmsMessageProducer;
import cc.raupach.backend.jms.Sender;

/**
 * @author Oliver Raupach, 21.10.2012
 */
@Service (value="BackendServiceFacade")
@Transactional
public class BackendServiceFacade
{

   @Autowired
   private SeriesDAO seriesDAO;
   
   @Autowired
   private RequestDAO requestDAO;
   
   @Autowired
   private JmsMessageProducer jmsMessageProducer;
   
   @Autowired
   private Sender sender;
   
   public void requestNewRoundTrip(Integer number) throws JMSException
   {
       Series series = seriesDAO.getSeriesByNumber(number);
       if ( series == null)
       {
          series = new Series();
          series.setSerialNumber(number);
          seriesDAO.makePersistent(series);
       }
       
       int newNumber = series.getRequests().size();
       Request request = new Request();
       request.setNumber(newNumber);
       request.setRequestDate(new Date());
       
       series.getRequests().add(request);
       requestDAO.makePersistent(request);
       
       jmsMessageProducer.sendNumberChangedMessage(newNumber);
       sender.sendTaskChangedMessage("ssdfs");
       
   }

}

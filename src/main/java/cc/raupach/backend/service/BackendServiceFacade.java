package cc.raupach.backend.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.raupach.backend.dao.RequestDAO;
import cc.raupach.backend.dao.SeriesDAO;
import cc.raupach.backend.entity.Request;
import cc.raupach.backend.entity.Series;

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
   
   public void requestNewRoundTrip(Integer number)
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
       
   }

}

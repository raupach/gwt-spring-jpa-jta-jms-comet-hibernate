package cc.raupach.backend.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import cc.raupach.backend.dao.SeriesDAO;
import cc.raupach.backend.dao.RequestDAO;
import cc.raupach.backend.entity.Series;
import cc.raupach.backend.entity.Request;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-core.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class PersistenceTest
{

   private static final int TEST_NUMBER = 999999;

   private static Logger log = LoggerFactory.getLogger(PersistenceTest.class);

   @Autowired
   private SeriesDAO seriesDAO;

   @Autowired
   private RequestDAO requestDAO;

   private Series testSeries;
   
   @Before
   public void setup()
   {
      testSeries = new Series();
      testSeries.setSerialNumber(Integer.valueOf(TEST_NUMBER));
      seriesDAO.makePersistent(testSeries);
   }
   
   
   @Test
   public void testDatabaseSave()
   {
      log.info("Running testDatabaseSave");

      Series series = new Series();
      series.setSerialNumber(Integer.valueOf(1));

      Request request = new Request();
      request.setRequestDate(new Date());
      request.setNumber(100);
      series.getRequests().add(request);
      requestDAO.makePersistent(request);
      
      request = new Request();
      request.setRequestDate(new Date());
      request.setNumber(101);
      series.getRequests().add(request);
      requestDAO.makePersistent(request);
      
      request = new Request();
      request.setRequestDate(new Date());
      request.setNumber(102);
      series.getRequests().add(request);
      requestDAO.makePersistent(request);
      
      seriesDAO.makePersistent(series);
   }
   
   @Test
   public void testDatabaseRetrieve()
   {
      log.info("Running testDatabaseRetrieve");
      
      List<Series> serials =  seriesDAO.get();
      
      for (Series series: serials)
      {
         for (Request request:series.getRequests())
         {
            log.info(request.getRequestDate()+ " : "+request.getNumber());
         }
      }
   }
   
   @Test
   public void testQuery ()
   {
      Series s = seriesDAO.getSeriesByNumber(Integer.valueOf(TEST_NUMBER));
      assertNotNull (s);
      assertEquals(testSeries.getId(), s.getId());
      
   }
}

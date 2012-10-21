package cc.raupach.backend.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import cc.raupach.backend.entity.Series;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-core.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class SeriesDAOTest
{

   private static final int _12345 = 12345;
   
   @Autowired
   private SeriesDAO seriesDAO;
   
   private Series series;
   
   
   @Before
   public void setup()
   {
      series = new Series();
      series.setSerialNumber(_12345);
      
      seriesDAO.makePersistent(series);
   }
   
   @Test
   public void testQuery ()
   {
      Series s = seriesDAO.getSeriesByNumber(Integer.valueOf(_12345));
      assertNotNull(s);
      assertEquals(series.getId(), s.getId());
   }

}

package cc.raupach.backend.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import cc.raupach.backend.entity.Series;
import cc.raupach.backend.util.GenericJpaDAOImpl;

@Component
public class SeriesDAOImpl extends GenericJpaDAOImpl<Series, Integer> implements SeriesDAO
{

  
   @Override
   public Series getSeriesByNumber(Integer serialNumber)
   {
      Query q = entityManager.createQuery("select s from Series s where s.serialNumber = :serialNumber");
      q.setParameter("serialNumber", serialNumber);

      try
      {
         Series results = (Series) q.getSingleResult();
         return results;
      }
      catch (NoResultException noRes)
      {
         return null;
      }
    
   }
  
}

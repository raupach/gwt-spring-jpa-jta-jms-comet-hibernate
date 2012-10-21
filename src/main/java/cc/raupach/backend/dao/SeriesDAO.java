package cc.raupach.backend.dao;

import cc.raupach.backend.entity.Series;
import cc.raupach.backend.util.GenericJpaDAO;


public interface SeriesDAO extends GenericJpaDAO<Series, Integer>
{

   public Series getSeriesByNumber(Integer number);

}

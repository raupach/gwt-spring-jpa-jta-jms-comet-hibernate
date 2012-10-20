package cc.raupach.starterdb.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import cc.raupach.starterdb.entity.Book;
import cc.raupach.starterdb.util.GenericJpaDAOImpl;

@Component
public class BookDAOImpl extends GenericJpaDAOImpl<Book, Integer> implements BookDAO
{

   public List<Book> getBooksByTitle(String title)
   {
      Query q = entityManager.createQuery("select b from Book b where b.title= :title");
      q.setParameter("title", title);

      List<Book> results = q.getResultList();
      return results;
   }

}

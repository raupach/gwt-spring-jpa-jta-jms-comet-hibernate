package cc.raupach.backend.dao;

import java.util.List;

import cc.raupach.backend.entity.Book;
import cc.raupach.backend.util.GenericJpaDAO;


public interface BookDAO extends GenericJpaDAO<Book, Integer>
{

   List<Book> getBooksByTitle(String title);

}

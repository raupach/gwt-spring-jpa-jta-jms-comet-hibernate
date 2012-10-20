package cc.raupach.starterdb.dao;

import java.util.List;

import cc.raupach.starterdb.entity.Book;
import cc.raupach.starterdb.util.GenericJpaDAO;


public interface BookDAO extends GenericJpaDAO<Book, Integer>
{

   List<Book> getBooksByTitle(String title);

}

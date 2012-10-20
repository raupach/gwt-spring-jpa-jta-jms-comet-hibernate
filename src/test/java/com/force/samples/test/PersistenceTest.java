package com.force.samples.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import cc.raupach.starterdb.dao.AuthorDAO;
import cc.raupach.starterdb.dao.BookDAO;
import cc.raupach.starterdb.entity.Author;
import cc.raupach.starterdb.entity.Book;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/applicationContext-core.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class PersistenceTest
{

   private static Logger log = LoggerFactory.getLogger(PersistenceTest.class);

   @Autowired
   private AuthorDAO authorDAO;

   @Autowired
   private BookDAO bookDAO;
   
   @Test
   public void testDatabaseSave()
   {
      log.info("Running testDatabaseSave");

      Author author = new Author();
      author.setFirstName("Oliver");
      author.setLastName("Raupach");

      Book book = new Book();
      book.setAuthor(author);
      book.setTitle("jdhsjg");
      author.getBooks().add(book);
      bookDAO.makePersistent(book);
      
      book = new Book();
      book.setAuthor(author);
      book.setTitle("1212112");
      author.getBooks().add(book);
      bookDAO.makePersistent(book);
      
      book = new Book();
      book.setAuthor(author);
      book.setTitle("xxxxxxxxxxxxxxxxssss");
      author.getBooks().add(book);
      bookDAO.makePersistent(book);
      
      authorDAO.makePersistent(author);
   }
   
   @Test
   public void testDatabaseRetrieve()
   {
      List<Author> authors =  authorDAO.get();
      
      for (Author author: authors)
      {
         for (Book book:author.getBooks())
         {
            log.info(book.getTitle());
         }
      }
      
      
   }
}

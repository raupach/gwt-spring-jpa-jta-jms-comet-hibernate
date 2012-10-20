package cc.raupach.starterdb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import cc.raupach.starterdb.util.AbstractBusinessObject;

@Entity
public class Author extends AbstractBusinessObject
{

   private static final long serialVersionUID = 3098655439675836742L;

   private String firstName;
   private String lastName;

   @OneToMany
   @JoinColumn(name = "author_id")
   @OrderColumn(name = "viele")
   private List<Book> books = new ArrayList<Book>();

   public String getFirstName()
   {
      return firstName;
   }

   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   public String getLastName()
   {
      return lastName;
   }

   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   public List<Book> getBooks()
   {
      return books;
   }

   public void setBooks(List<Book> books)
   {
      this.books = books;
   }

}

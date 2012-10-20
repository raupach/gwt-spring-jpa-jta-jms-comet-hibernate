package cc.raupach.starterdb.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import cc.raupach.starterdb.util.AbstractBusinessObject;

@Entity
public class Book extends AbstractBusinessObject
{

   private static final long serialVersionUID = -3399441546287302881L;

   private String title;

   @ManyToOne
   @JoinColumn(name = "author_id", updatable = false, insertable = false)
   private Author author;

   private Date publicationDate;

   public String getTitle()
   {
      return title;
   }

   public void setTitle(String title)
   {
      this.title = title;
   }

   public Author getAuthor()
   {
      return author;
   }

   public void setAuthor(Author author)
   {
      this.author = author;
   }

   public Date getPublicationDate()
   {
      return publicationDate;
   }

   public void setPublicationDate(Date publicationDate)
   {
      this.publicationDate = publicationDate;
   }

}

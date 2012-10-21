package cc.raupach.backend.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cc.raupach.backend.util.AbstractBusinessObject;

@Entity
public class Request extends AbstractBusinessObject
{

   private static final long serialVersionUID = -3399441546287302881L;

   @Temporal(value=TemporalType.TIMESTAMP)
   private Date requestDate;

   private Integer number;

   @ManyToOne
   @JoinColumn(name = "author_id", updatable = false, insertable = false)
   private Series series;

   public Date getRequestDate()
   {
      return requestDate;
   }

   public void setRequestDate(Date requestDate)
   {
      this.requestDate = requestDate;
   }

   public Integer getNumber()
   {
      return number;
   }

   public void setNumber(Integer number)
   {
      this.number = number;
   }

   public Series getSeries()
   {
      return series;
   }

   public void setSeries(Series series)
   {
      this.series = series;
   }

  

}

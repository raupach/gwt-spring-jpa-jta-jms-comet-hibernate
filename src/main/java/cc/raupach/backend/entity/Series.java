package cc.raupach.backend.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import cc.raupach.backend.util.AbstractBusinessObject;

@Entity
public class Series extends AbstractBusinessObject
{

   private static final long serialVersionUID = 3098655439675836742L;

   private Integer serialNumber;

   @OneToMany
   @JoinColumn(name = "request_id")
   @OrderColumn(name = "request_index")
   private List<Request> requests = new ArrayList<Request>();

   public Integer getSerialNumber()
   {
      return serialNumber;
   }

   public void setSerialNumber(Integer serialNumber)
   {
      this.serialNumber = serialNumber;
   }

   public List<Request> getRequests()
   {
      return requests;
   }

   public void setRequests(List<Request> requests)
   {
      this.requests = requests;
   }

 
}

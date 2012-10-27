package cc.raupach.backend.jms;

public class JsonNumberDto
{
   private int number;

   public JsonNumberDto()
   {
   }
   
   public JsonNumberDto(int number)
   {
      this.number = number;
   }

   public int getNumber()
   {
      return number;
   }

   public void setNumber(int number)
   {
      this.number = number;
   }
   
}

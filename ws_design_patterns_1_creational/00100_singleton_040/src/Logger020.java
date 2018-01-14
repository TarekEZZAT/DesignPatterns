import java.util.Date;

public class Logger020
// Threading
{
	   private Date idDate ;
   private Logger020(){
	   this.setIdDate(new Date());
   }

 
	 private static Logger020 uniqueInstance;

   public static Logger020 getInstance()
   {

     if (uniqueInstance == null)
            uniqueInstance = new Logger020();

         return uniqueInstance;

   }

public Date getIdDate() {
	return idDate;
}

public void setIdDate(Date idDate) {
	this.idDate = idDate;
}

   
   
}
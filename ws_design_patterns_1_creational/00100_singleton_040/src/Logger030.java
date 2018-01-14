import java.util.Date;

public class Logger030
//Threadin Single Lock
{
	   private Date idDate ;
   private Logger030(){
	   this.setIdDate(new Date());
   }

 
	 private static Logger030 uniqueInstance;

   public static Logger030 getInstance()
   {
	   synchronized (Logger030.class){
     if (uniqueInstance == null)
            uniqueInstance = new Logger030();

         return uniqueInstance;
	   }
   }

public Date getIdDate() {
	return idDate;
}

public void setIdDate(Date idDate) {
	this.idDate = idDate;
}

   
   
}
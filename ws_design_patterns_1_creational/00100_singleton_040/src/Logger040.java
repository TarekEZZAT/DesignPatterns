import java.util.Date;

public class Logger040
//Threadin Double Lock
{
	   private Date idDate ;
   private Logger040(){
	   this.setIdDate(new Date());
   }

 
	 private volatile static Logger040 uniqueInstance;

   public static Logger040 getInstance()
   {
	   synchronized (Logger040.class){
     if (uniqueInstance == null)
            uniqueInstance = new Logger040();

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
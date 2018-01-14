import java.util.concurrent.TimeUnit;

public class Start {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Logger010 l010 = new Logger010();
		l010.LogMessage();
		//
		Logger020 l020 = Logger020.getInstance();
		System.out.println(l020.getIdDate().toString());
		TimeUnit.SECONDS.sleep(2);
		Logger020 l025 = Logger020.getInstance();
		System.out.println(l025.getIdDate().toString());
		//
		Logger030 l030 = Logger030.getInstance();
		System.out.println(l030.getIdDate().toString());
		TimeUnit.SECONDS.sleep(2);
		Logger030 l035 = Logger030.getInstance();
		System.out.println(l035.getIdDate().toString());
		//
		Logger040 l040 = Logger040.getInstance();
		System.out.println(l040.getIdDate().toString());
		TimeUnit.SECONDS.sleep(2);
		Logger040 l045 = Logger040.getInstance();
		System.out.println(l045.getIdDate().toString());
		
	}

}

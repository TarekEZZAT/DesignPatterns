package singleton.lab_010;

public class Logger {

/*
 
public class Logger {
    
		public Logger() { }

		public void WriteLine(string text) { }

        public string ReadEntireLog()
        {
            return “Log Entries Here”;
        }
} 	
 	
 */
	

	        private Logger() { }

	        private static Logger instance;
	        public static Logger getInstance()
	        {
	             if (instance == null)
	                 instance = new Logger();

	              return instance;
	        }

	        //Functions
			//. . . 
	
	
}

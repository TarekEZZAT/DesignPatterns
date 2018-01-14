package logger_015.standard;

public class Start {
	static int levelMax = 3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger l = new Logger();
		for (int i = 0; i < 15; i++) {
			int level = i % 3;
			l.LogMessage(level);
		}
		
		for (int level = 0; level < levelMax; level++) {
			l.LogMessage(level);
		}

	}

}

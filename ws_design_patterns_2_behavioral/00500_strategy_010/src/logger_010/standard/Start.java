package logger_010.standard;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger l = new Logger();
		for (int i = 0; i < 15; i++) {
			int level = i % 2;
			l.LogMessage(level);
		}
	}

}

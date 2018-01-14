import java.sql.Connection;

public class HelperFacade {

	public static void generateReport(DBTypes dbType, ReportTypes reportType, String tableName) {
		Connection con = null;
		switch (dbType) {
		case MYSQL:
			con = MySqlHelper.getMySqlDBConnection();
			MySqlHelper mySqlHelper = new MySqlHelper();
			System.out.println("MySQL selected");
			switch (reportType) {
			case HTML:
				mySqlHelper.generateMySqlHTMLReport(tableName, con);
				System.out.println("MySQL HTML report");
				break;
			case PDF:
				mySqlHelper.generateMySqlPDFReport(tableName, con);
				System.out.println("MySQL PDF report");
				break;
			}
			break;
		case ORACLE:
			con = OracleHelper.getOracleDBConnection();
			OracleHelper oracleHelper = new OracleHelper();
			System.out.println("Oracle selected");
			switch (reportType) {
			case HTML:
				oracleHelper.generateOracleHTMLReport(tableName, con);
				System.out.println("Oracle HTML report");
				break;
			case PDF:
				oracleHelper.generateOraclePDFReport(tableName, con);
				System.out.println("Oracle PDF report");
				break;
			}
			break;
		}
	}

	public static enum DBTypes {
		MYSQL, ORACLE;
	}

	public static enum ReportTypes {
		HTML, PDF;
	}
}
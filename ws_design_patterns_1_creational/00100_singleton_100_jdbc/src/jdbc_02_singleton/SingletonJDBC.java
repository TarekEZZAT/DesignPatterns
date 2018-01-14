package jdbc_02_singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class SingletonJDBC {
	Connection connection;
	private static HashMap<String, Connection> connectionPool=new HashMap<String, Connection>();
	private static int counter = 0;
	
	public static void main(String[] args) {
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/coffeebreak";
		String user;
		String password;
		// root
		user = "root";
		password = "";
		System.out.println("Counter : >>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + user );

		new SingletonJDBC(driverName, url, user, password);
		// user
		user = "peter";
		password = "peter";
		System.out.println("Counter : >>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + user );

		new SingletonJDBC(driverName, url, user, password);

		// user
		user = "peter";
		password = "peter";
		System.out.println("Counter : >>>>>>>>>>>>>>>>>>>>>>>>>>>>> " );

		new SingletonJDBC(driverName, url, user, password);

	}

	public SingletonJDBC(String driverName, String url, String user, String password) {

		try {
			String key = driverName + url + user + password;
			if (connectionPool.get(key) != null) {
				connection = connectionPool.get(key);
				System.out.println("SAME CONNECTION : <<<<<<<<<<<<<<<<<<<< Counter " + user + " " + counter);

			} else {
				System.out.println("NEW  CONNECTION : >>>>>>>>>>>>>>>>>>>> Counter " + user + " " + ++counter);
				Class.forName(driverName).newInstance();
				connection = DriverManager.getConnection(url, user, password);
				connectionPool.put(key, connection);
			}
			doTests();
			//connection.close();
			
			/*
			 * Class.forName("com.mysql.jdbc.Driver").newInstance(); String url
			 * = "jdbc:mysql://localhost/coffeebreak"; connection =
			 * DriverManager.getConnection(url, "root", ""); doTests();
			 * connection.close();
			 */
		} catch (ClassNotFoundException ex) {
			System.err.println(ex.getMessage());
		} catch (IllegalAccessException ex) {
			System.err.println(ex.getMessage());
		} catch (InstantiationException ex) {
			System.err.println(ex.getMessage());
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}



	private void doTests() {
		doSelectTest();

		doInsertTest();
		doSelectTest();
		doUpdateTest();
		doSelectTest();
		doDeleteTest();
		doSelectTest();
		System.out.println("+++++++++++++++++++++++++");
	}

	private void doSelectTest() {
		System.out.println("[OUTPUT FROM SELECT]");
		String query = "SELECT COF_NAME, PRICE FROM COFFEES";
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String s = rs.getString("COF_NAME");
				float n = rs.getFloat("PRICE");
				System.out.println(s + "   " + n);
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private void doInsertTest() {
		System.out.print("\n[Performing INSERT] ... ");
		try {
			Statement st = connection.createStatement();
			st.executeUpdate("INSERT INTO COFFEES " + "VALUES ('BREAKFAST BLEND', 200, 7.99, 0, 0)");
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private void doUpdateTest() {
		System.out.print("\n[Performing UPDATE] ... ");
		try {
			Statement st = connection.createStatement();
			st.executeUpdate("UPDATE COFFEES SET PRICE=4.99 WHERE COF_NAME='BREAKFAST BLEND'");
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private void doDeleteTest() {
		System.out.print("\n[Performing DELETE] ... ");
		try {
			Statement st = connection.createStatement();
			st.executeUpdate("DELETE FROM COFFEES WHERE COF_NAME='BREAKFAST BLEND'");
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}
}

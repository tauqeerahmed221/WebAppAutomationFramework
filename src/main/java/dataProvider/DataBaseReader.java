package dataProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import java.util.regex.*;
import java.sql.*;
import java.util.*;

public class DataBaseReader {
	DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration();
	public void executeQuery(String query) throws SQLException {
		Statement stmt = dataBaseConnection().createStatement();
		stmt.executeQuery(query);
	}
	
	public Connection dataBaseConnection() throws SQLException {
		Connection connection = null;
		for (int i = 0; i <= 5; i++) {
 
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = databaseConfiguration.getDatabaseURL();
				String userName = databaseConfiguration.getDatabaseUserName();
				String password = databaseConfiguration.getDatabasePassword();
				connection = DriverManager.getConnection(url, userName, password);
				break;
			} catch (Exception e) {
				try {
					System.out.println(e.getMessage());
					connection.close();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						System.err.println("Thread got interepted");
						e1.printStackTrace();
					}
				} catch (SQLException ex) {
					// Log closing connection failure
					System.err.println("Failed to close connection: " + ex.getMessage());
				}
				if (i == 5) {
					e.printStackTrace();
					System.err.print(e.getMessage());
					Assert.fail(e.getMessage());
 
				}
			}
		}
		return connection;
	}

	public List<String> getListOfOptIDFromRET(String optName, String appName)
			throws ClassNotFoundException, SQLException {
		List<String> listOfOptName = new ArrayList<>();
		Statement stmt = dataBaseConnection().createStatement();
		String prgRef = "";
		String idPrefix = databaseConfiguration.getOptNamePrefix();
		try {
			while (true) {

				String stringQuery = "select prog_ref,app_name, parent_ref, prog_order, menu_title_eng, disp_order from opt where prog_ref = '"
						+ optName + "' and app_name = '" + appName + "'";
				ResultSet executeQuery = stmt.executeQuery(stringQuery);
				while (executeQuery.next()) {
					optName = executeQuery.getString("PARENT_REF");
					prgRef = executeQuery.getString("PROG_REF");
					listOfOptName.add(idPrefix + prgRef);
				}
				if (optName.equals("ROOT")) {
					break;
				}

			}
			dataBaseConnection().close();
			return listOfOptName;
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			return null;
		}

	}

	public List<String> getListOfOptIDFromRETP() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = databaseConfiguration.getDatabaseURL();
		String userName = databaseConfiguration.getDatabaseUserName();
		String password = databaseConfiguration.getDatabasePassword();
		List<String> listOfOptName = new ArrayList<>();
		Connection connection = DriverManager.getConnection(url, userName, password);
		Statement stmt = connection.createStatement();
		String optName = databaseConfiguration.getOptName();
		String prgRef = "";
		String idPrefix = databaseConfiguration.getOptNamePrefix();

		while (true) {

			String stringQuery = "select prog_ref,app_name, parent_ref, prog_order, menu_title_eng, disp_order from opt where prog_ref = '"
					+ optName + "' and app_name = 'RETP'";
			ResultSet executeQuery = stmt.executeQuery(stringQuery);
			while (executeQuery.next()) {
				optName = executeQuery.getString("PARENT_REF");
				prgRef = executeQuery.getString("PROG_REF");
				listOfOptName.add(idPrefix + prgRef);
			}
			if (optName.equals("ROOT")) {

				break;
			}

		}

		connection.close();
		return listOfOptName;

	}
	
	public List<String> getListOfOptID(String optName, String appName) throws ClassNotFoundException, SQLException {
		List<String> listOfOptName = new ArrayList<>();
		Statement stmt = dataBaseConnection().createStatement();
		String prgRef = "";
		String idPrefix = databaseConfiguration.getOptNamePrefix();
		try {
			while (true) {

				String stringQuery = "select prog_ref,app_name, parent_ref, prog_order, menu_title_eng, disp_order from opt where prog_ref = '"
						+ optName + "' and app_name = '" + appName + "'";
				ResultSet executeQuery = stmt.executeQuery(stringQuery);
				while (executeQuery.next()) {
					optName = executeQuery.getString("PARENT_REF");
					prgRef = executeQuery.getString("PROG_REF");
					listOfOptName.add(idPrefix + prgRef);
				}
				if (optName.equals("ROOT")) {
					break;
				}

			}
			dataBaseConnection().close();
			return listOfOptName;
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			return null;
		}

	}

	public List<String> fetchDataFromDatabase(String objectName) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = databaseConfiguration.getDatabaseURL();
		String userName = databaseConfiguration.getDatabaseUserName();
		System.out.println(userName);
		String password = databaseConfiguration.getDatabasePassword();

		Connection connection = DriverManager.getConnection(url, userName, password);
		Statement stmt = connection.createStatement();

		String userQuery = objectName;

		List<String> resultList = new ArrayList<>();

		ResultSet resultSet = stmt.executeQuery(userQuery);

		while (resultSet.next()) {
			String data = resultSet.getString(1); // Assuming data is in the first column
			resultList.add(data);
		}

		connection.close();
		return resultList;
	}

	public List<String> fetchDataFromDatabase2(String query) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = databaseConfiguration.getDatabaseURL();
		String userName = databaseConfiguration.getDatabaseUserName();
		String password = databaseConfiguration.getDatabasePassword();

		try (Connection connection = DriverManager.getConnection(url, userName, password);
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			ResultSet resultSet = preparedStatement.executeQuery();
			List<String> resultList = new ArrayList<>();
			while (resultSet.next()) {
				String data = resultSet.getString(1); // Assuming data is in the first column
				resultList.add(data);
			}
			return resultList;

		}
	}

	public String getDealStatus(String Query, String userId, String serialNo) {
		String status = null;
		try {

			// Constructing the SQL query dynamically using prepared statement to prevent
			// SQL injection
			String sql = "Query";

			// Creating a prepared statement
			PreparedStatement preparedStatement = dataBaseConnection().prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, serialNo);

			// Executing the query
			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println(resultSet);

			// Retrieving the result
			if (resultSet.next()) {
				status = resultSet.getString("");
			}

			// Closing resources
			resultSet.close();
			preparedStatement.close();
			dataBaseConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public String getDealStatus2(String serialNo) {
		String status = null;
		try {

			// Constructing the SQL query dynamically using prepared statement to prevent
			// SQL injection
			String sql = "SELECT STATUS FROM TRSDEAL WHERE SERIAL_NO = ?";

			// Creating a prepared statement
			PreparedStatement preparedStatement = dataBaseConnection().prepareStatement(sql);
			preparedStatement.setString(1, serialNo); // Set SERIAL_NO as a string parameter

			// Print the actual query being executed using PreparedStatement's toString()
			// method
			System.out.println("Executing query: " + preparedStatement.toString());

			// Executing the query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Retrieving the result
			if (resultSet.next()) {
				status = resultSet.getString("STATUS");
			}

			// Closing resources
			resultSet.close();
			preparedStatement.close();
			dataBaseConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public static void executeQueries() {
		Connection conn = null;
		Statement stmt = null;

		try {
			// Create an instance of DataBaseReader
			DataBaseReader reader = new DataBaseReader();

			// Get a database connection
			conn = reader.dataBaseConnection();

			// Create a statement
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			// Execute your SQL queries
			String sql1 = "UPDATE S_APPLOG SET USER_STS='A' WHERE USER_ID = 'RISHABH'";
			String sql2 = "UPDATE S_LOC SET USER_LOC_STS='A' WHERE USER_ID = 'RISHABH'";
			String sql3 = "UPDATE USR SET USER_STS='A' WHERE USER_ID = 'RISHABH'";
			String sql4 = "COMMIT";

			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql3);
			stmt.executeUpdate(sql4);

			System.out.println("SQL queries executed successfully.");

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
		} finally {
			// Close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public static void executeQuerie(String query) {
		Connection conn = null;
		Statement stmt = null;

		try {
			// Create an instance of DataBaseReader
			DataBaseReader reader = new DataBaseReader();

			// Get a database connection
			conn = reader.dataBaseConnection();

			// Disable auto-commit
			conn.setAutoCommit(false);

			// Create a statement
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			// Execute the SQL query
			stmt.executeUpdate(query);

			// Commit the transaction
			conn.commit();

			System.out.println("SQL query executed successfully.");

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			// Rollback in case of an error
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace();
		} finally {
			// Close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (conn != null) {
					// Re-enable auto-commit
					conn.setAutoCommit(true);
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

}

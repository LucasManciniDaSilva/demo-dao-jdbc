package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

  //instantiated a new Connection receiving null;
	private static Connection conn = null;

	//Created a method to make a connection with DB
	public static Connection getConnection() {
		//if
		if (conn == null) {
			//try block
			try {
				//instantiated a new properties receiving the method loadProperties.
				Properties ps = loadProperties();
				//get property receiving a String as argument.
				String url = ps.getProperty("dburl");
				//Methdo getConnection of the class DirverManager
				conn = DriverManager.getConnection(url, ps);
				}

			//Exception
			catch(SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
		return conn;
	}

	 //Method to close the connection
	 public static void closeConnection() {
		 if(conn != null) {
			 try {
				 //method to close the connection.
				 conn.close();
			 }
			 catch(SQLException e) {
				 throw new DBException(e.getMessage());
			 }
		 }
	 }

	//method to read the properties of DB
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")){
			//instantiated a new Properties
			Properties ps = new Properties();
			//method to load the value ont FileInputStream
			ps.load(fs);
			return ps;
		}
		catch(IOException e) {
			throw new DBException(e.getMessage());
		}
	}
}

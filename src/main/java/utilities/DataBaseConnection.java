package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {

	static String connectionString = "jdbc:mysql://localhost:3306/amazon";

	public static ResultSet setConnection(String query) {
		try {
			Connection con = DriverManager.getConnection(connectionString, "root", "password");
			System.out.println("connection established");
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Database Connection has problem");
		return null;

	}

}

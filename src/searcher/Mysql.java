package searcher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;


public class Mysql {
	public static void connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void SavetoSql(String url, String headline, String snippet) {
		connection();
		String host = "jdbc:mysql://localhost/article?autoReconnect=true&useSSL=false";
		String username="root";
		String password="950503";
		try {
			Connection connect = DriverManager.getConnection(host,username,password);
			PreparedStatement statement = (PreparedStatement) connect.prepareStatement("INSERT INTO new_table(url,headline,snippet)VALUES(?,?,?)");
			statement.setString(1, url);
			statement.setString(2, headline);
			statement.setString(3, snippet);
			statement.executeUpdate();
			statement.close();
			connect.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		System.out.println("MySQL works well......");
	}
	
}

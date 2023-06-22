	package controler;
	
	import java.sql.*;
	
	
	public class DBconnect {
		public Connection connection;
		public DBconnect() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnv", "root","");
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		public Connection getConnection() {
			return connection;
		}
	
	}

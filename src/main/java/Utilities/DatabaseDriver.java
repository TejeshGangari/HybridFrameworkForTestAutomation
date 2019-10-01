package Utilities;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import CoreComponents.ReusableLibrary;

public class DatabaseDriver extends ReusableLibrary{

	public DatabaseDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(prop.getProperty("DBURL"));
			st = con.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet executeQuery(String sql) {
		
		try {
			rs=st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
}

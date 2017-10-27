/**
 * 
 */
package utils.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import utils.load.dataSource.LoadProperty;


public abstract class ConnectionDAO {

	private static Connection con;
	private static String db_connection;
	static {
		try {
			db_connection = LoadProperty.getVar("db_connection",
					"config");
			if (db_connection == "mysql") {
				Class.forName("com.mysql.jdbc.Driver");
			}

			else if(db_connection == "oracle"){
				Class.forName("oracle.jdbc.driver.OracleDriver");
			}
			else {
				System.out.println("Currently p3selenium only support mysql and oracle DB");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	}

	public static Connection getConnection() {
		try {
			if ((con == null) || (con.isClosed()))
				if (db_connection == "mysql") {
					con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/db", "iqa", "");
				} else {
					con = DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:db", "iqa", "");
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;

	}

}

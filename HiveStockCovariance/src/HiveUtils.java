import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Utility Class for Hive operations
 * @author himanshu.agrawal
 *
 */
public class HiveUtils {
	private static final String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
	public static Statement loadHiveDriver() throws SQLException {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			System.out.println("Hive Driver not found.");
			e.printStackTrace();
			System.exit(1);
		}
		Connection con = DriverManager.getConnection(
				"jdbc:hive://localhost:10000/default", "", "");
		Statement stmt = con.createStatement();
		return stmt;
	}
}

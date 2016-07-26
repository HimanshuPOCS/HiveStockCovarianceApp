import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This application will analyse the stock exchange dataset and calculate the
 * Covariance between the stocks for each month. This will help a stock broker
 * in recommending the stocks to his customers.
 * 
 * Covariance is the finance term represents the degree or amount that two
 * stocks or financial instruments move together or apart from each other. With
 * covariance, investors have the opportunity to seek out different investment
 * options based upon their respective risk profile. It is a statistical measure
 * of how one investment moves in relation to another.
 * 
 * @author himanshu.agrawal
 * 
 */
public class StockCovarianceApplication {

	public static void main(String[] args) throws SQLException {

		// Load the hive drivers
		Statement statement = HiveUtils.loadHiveDriver();

		// Create the hive database
		createDB(statement);	

		// Create the hive table
		createTable(statement);

		// Load Data to Hive Table
		loadIntoHiveTable(statement);
		
		// Take year input in 'YYYY' format from console
		int year = takeInputFromConsole();

		// Calculate the Stock Covariance
		StockCovarianceCalculator.calculateCovariance(statement, year);

	}

	/**
	 * Accept valid year in 'YYYY' format from input
	 * 
	 * @return year
	 */
	private static int takeInputFromConsole() {
		int year = 0;
		boolean isValid = true;
		System.out
				.println("Please provide the year in YYYY format between 1999 and 2010 for which Covariance needs to be calculated.");

		while (isValid) {
			try {
				Scanner in = new Scanner(System.in);
				year = in.nextInt();
			} catch (InputMismatchException e) {
				System.out
						.println("Please provide valid Year between 1999 and 2010");
				isValid = true;
				continue;
			}
			if (year < 1999 || year > 2010) {
				System.out
						.println("Please provide valid Year between 1999 and 2010");
				isValid = true;
				continue;
			}
			isValid = false;
		}
		return year;
	}

	/**
	 * @param stmt
	 * @throws SQLException
	 */
	private static void loadIntoHiveTable(Statement stmt) throws SQLException {
		System.out.println("Loading data into Hive Table : "
				+ StockCovarianceConstants.STOCK_TABLE_NAME);
		stmt.executeQuery(StockCovarianceConstants.LOAD_STOCK_DATA_QUERY);

		// count the records
		ResultSet res = stmt.executeQuery("Select count(*) from "
				+ StockCovarianceConstants.STOCK_TABLE_NAME);
		if (res.next()) {
			System.out.println("The number of records into "
					+ StockCovarianceConstants.STOCK_TABLE_NAME + " are "
					+ res.getString(1));
		}
	}

	/**
	 * @param statement
	 * @throws SQLException
	 */
	private static void createDB(Statement statement) throws SQLException {
		statement.executeQuery("CREATE DATABASE IF NOT EXISTS "
				+ StockCovarianceConstants.STOCK_DB_NAME);
		statement.executeQuery("USE " + StockCovarianceConstants.STOCK_DB_NAME);

	}

	/**
	 * @param stmt
	 * @throws SQLException
	 */
	private static void createTable(Statement stmt) throws SQLException {
		stmt.executeQuery("Drop Table if exists "
				+ StockCovarianceConstants.STOCK_TABLE_NAME);
		stmt.executeQuery("Create Table "
				+ StockCovarianceConstants.STOCK_TABLE_NAME
				+ "(exchange String,stock_symbol String,stock_date String,stock_price_open double, "
				+ "stock_price_high double, stock_price_low double, stock_price_close double, stock_volume double, stock_price_adj_close double) "
				+ "row format delimited fields terminated by ','");
	}

}

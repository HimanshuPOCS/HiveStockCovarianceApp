import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This Class will calculate the Covariance of Stocks Data. The Stock Covariance
 * represents the degree or amount that two stocks or financial instruments move
 * together or apart from each other. With covariance, investors have the
 * opportunity to seek out different investment options based upon their
 * respective risk profile. It is a statistical measure of how one investment
 * moves in relation to another. 
 * - A positive covariance means that asset
 * returns moved together. If investment instruments or stocks tend to be up or
 * down during the same time periods, they have positive covariance. 
 * - A negative covariance means returns move inversely. If one investment tends to
 * be up while the other is down, they have negative covariance.
 * 
 * @author himanshu.agrawal
 * 
 */
public class StockCovarianceCalculator {

	/**
	 * Calculate the Stock Covariance for the provided year from the Stock dataset
	 * @param stmt
	 * @param year
	 * @throws SQLException
	 */
	public static void calculateCovariance(Statement stmt, int year)
			throws SQLException {
		String covarianceQuery = "Select a.STOCK_SYMBOL, b.STOCK_SYMBOL, month(a.STOCK_DATE),	"
				+ "(AVG(a.STOCK_PRICE_HIGH*b.STOCK_PRICE_HIGH) - (AVG(a.STOCK_PRICE_HIGH)*AVG(b.STOCK_PRICE_HIGH)))	"
				+ "from nyse a join nyse b on	a.STOCK_DATE=b.STOCK_DATE "
				+ "where a.STOCK_SYMBOL<b.STOCK_SYMBOL and year(a.STOCK_DATE)="
				+ year
				+ " group by a.STOCK_SYMBOL, b. STOCK_SYMBOL,	month(a.STOCK_DATE)";

		System.out.println("The covariance result for " + year
				+ "  are as below : ");
		System.out
				.println("********************************************************");
		System.out
				.println("Stock Symbol(A)	\t 	Stock Symbol(B)	\t	Month	\t	Covariance");
		ResultSet res = stmt.executeQuery(covarianceQuery);
		int size = 0;
		while (res.next()) {
			System.out.println(res.getString(1) + "\t" + res.getString(2)
					+ "\t" + res.getString(3) + "\t" + res.getString(4));
			size++;
		}
		if (size == 0) {
			System.out
					.println(" No records exist for any two stocks on which Covariance can be calculated.");
		}

	}

}

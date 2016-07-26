/**
 * This class will have all the constansts defined for Stock Data Analysis
 * @author himanshu.agrawal
 *
 */
public class StockCovarianceConstants {
	public static final String STOCK_DB_NAME = "STOCK";
	public static final String STOCK_TABLE_NAME = "NYSE";
	public static final String FILE_PATH = "/home/cloudera/HiveStockCovariance/data/NYSE_daily_prices_Q.csv";
	public static final String LOAD_STOCK_DATA_QUERY = "load data local inpath '"+  FILE_PATH+"' overwrite into table " + STOCK_TABLE_NAME;

}

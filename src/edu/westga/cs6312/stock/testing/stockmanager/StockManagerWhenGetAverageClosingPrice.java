package edu.westga.cs6312.stock.testing.stockmanager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.stock.model.StockManager;
import edu.westga.cs6312.stock.model.StockRecord;

/**
 * Provides unit tests to verify the expected behavior of StockManager's
 * getAverageClosingPrice method.
 * 
 * @author Spencer Dent
 * @version 2021-05-02
 */
public class StockManagerWhenGetAverageClosingPrice {

	/**
	 * Tests getAverageClosingPrice on StockManager with one record. It should
	 * return the closing price of that record.
	 */
	@Test
	public void testGetAverageClosingPriceOnStockManagerWithOneRecordShouldReturnClosingPriceOfThatRecord() {
		StockManager testStockManager = new StockManager("Nikkei");
		testStockManager.addStockRecord(new StockRecord(LocalDate.parse("2020-06-09"), 23135.789063, 23185.849609,
				22933.140625, 23091.029297, 23091.029297, 91500000));

		assertEquals(23091.029297, testStockManager.getAverageClosingPrice());
	}

	/**
	 * Tests getAverageClosingPrice on StockManager with multiple records. It should
	 * average the closing prices of the records.
	 */
	@Test
	public void testGetAverageClosingPriceOnStockManagerWithMultipleRecordsShouldReturnAverageOfClosingPrices() {
		StockManager testStockManager = new StockManager("Nikkei");
		testStockManager.addStockRecord(new StockRecord(LocalDate.parse("2020-06-09"), 23135.789063, 23185.849609,
				22933.140625, 23091.029297, 23091.029297, 91500000));
		testStockManager.addStockRecord(new StockRecord(LocalDate.parse("2021-04-01"), 29441.910156, 29585.460938,
				29318.820313, 29388.869141, 29388.869141, 75600000));

		double expectedAverage = (29388.869141 + 23091.029297) / 2.0;

		assertEquals(expectedAverage, testStockManager.getAverageClosingPrice());
	}
}

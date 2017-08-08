package citi.hibernate.entity;
// Generated Aug 7, 2017 7:37:13 PM by Hibernate Tools 5.0.6.Final

/**
 * Stock generated by hbm2java
 */
public class Stock implements java.io.Serializable {

	private int stockId;
	private Portfolio portfolio;
	private String stockTicker;

	public Stock() {
	}

	public Stock(int stockId) {
		this.stockId = stockId;
	}

	public Stock(int stockId, Portfolio portfolio, String stockTicker) {
		this.stockId = stockId;
		this.portfolio = portfolio;
		this.stockTicker = stockTicker;
	}
	public Stock(Portfolio portfolio, String stockTicker) {
		this.portfolio = portfolio;
		this.stockTicker = stockTicker;
	}
	public int getStockId() {
		return this.stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public Portfolio getPortfolio() {
		return this.portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	public String getStockTicker() {
		return this.stockTicker;
	}

	public void setStockTicker(String stockTicker) {
		this.stockTicker = stockTicker;
	}

}

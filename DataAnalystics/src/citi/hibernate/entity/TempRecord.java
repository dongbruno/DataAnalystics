package citi.hibernate.entity;

public class TempRecord {
	private String ticker;
	private Double open;
	private Double close;
	private String changePerc;
	private String change;
	public TempRecord(String ticker, Double open, Double close, String changePerc, String change) {
		super();
		this.ticker = ticker;
		this.open = open;
		this.close = close;
		this.changePerc = changePerc;
		this.change = change;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public Double getOpen() {
		return open;
	}
	public void setOpen(Double open) {
		this.open = open;
	}
	public Double getClose() {
		return close;
	}
	public void setClose(Double close) {
		this.close = close;
	}
	public String getChangePerc() {
		return changePerc;
	}
	public void setChangePerc(String changePerc) {
		this.changePerc = changePerc;
	}
	public String getChange() {
		return change;
	}
	public void setChange(String change) {
		this.change = change;
	}
	
}

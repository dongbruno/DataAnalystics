package citi.hibernate.entity;

public class TempRecord {
	private String ticker;
	private Double open;
	private String changePerc;
	private String change;
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
	public TempRecord(String ticker, Double open, String changePerc, String change) {
		this.ticker = ticker;
		this.open = open;
		this.changePerc = changePerc;
		this.change = change;
	}
	
}

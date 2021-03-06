package citi.hibernate.entity;
// Generated Aug 9, 2017 1:27:15 PM by Hibernate Tools 5.0.6.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Portfolio generated by hbm2java
 */
public class Portfolio implements java.io.Serializable {

	private Integer portfolioId;
	private User user;
	private String portfolioname;
	private Set stocks = new HashSet(0);

	public Portfolio() {
	}

	public Portfolio(User user, String portfolioname, Set stocks) {
		this.user = user;
		this.portfolioname = portfolioname;
		this.stocks = stocks;
	}
	public Portfolio(User user, String portfolioname) {
		this.user = user;
		this.portfolioname = portfolioname;
	}
	public Integer getPortfolioId() {
		return this.portfolioId;
	}

	public void setPortfolioId(Integer portfolioId) {
		this.portfolioId = portfolioId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPortfolioname() {
		return this.portfolioname;
	}

	public void setPortfolioname(String portfolioname) {
		this.portfolioname = portfolioname;
	}

	public Set getStocks() {
		return this.stocks;
	}

	public void setStocks(Set stocks) {
		this.stocks = stocks;
	}

}

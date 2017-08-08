package citi.service;

import java.util.List;

public interface PortfolioNameService {
	public String createPortfolioName(String username, String portfolioName);
	public List<String> getPortfolioName(String username);
	public List<String> getTickersFromPortfolio(String username, String portfolioName);
	public String addTickerToPortfolio(String username, String portfolioName, String ticker);
	public String deletePortfolioName(String username, String portfolioName);
	public String deleteTickerFromPortfolio(String username, String portfolioName, String ticker);
}

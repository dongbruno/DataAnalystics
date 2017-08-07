package citi.service;

import java.util.List;
import java.util.Map;

public interface PortfolioNameService {
	public String createPortfolioName(String username, String portfolioName);
	public List<Map<String, List<String>>> getPortfolioName(String username);
	public List<String> getTickersFromPortfolio(String username, String portfolioName);
}

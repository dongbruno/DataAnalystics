package citi.service;

import java.util.List;

public interface PortfolioNameService {
	public String createPortfolioName(String username, String portfolioName);
	public List<String> getPortfolioName(String username);
}

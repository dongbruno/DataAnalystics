package citi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import citi.hibernate.entity.Record;

public interface PortfolioNameService {
	public String createPortfolioName(String username, String portfolioName);
	public List<String> getPortfolioName(String username);
	public List<String> getTickersFromPortfolio(String username, String portfolioName);
	public ArrayList<HashMap<String, Object>> getRecordsFromPortfolio(String username, String portfolioName);
	public String addTickerToPortfolio(String username, String portfolioName, String ticker);
	public String deletePortfolioName(String username, String portfolioName);
	public String deleteTickerFromPortfolio(String username, String portfolioName, String ticker);
}

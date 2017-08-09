package citi.hibernate.dao;

import java.util.List;
import java.util.Map;

import citi.hibernate.entity.Record;

public interface PortfolioDao {
       public List<String> getPortfolioName(String username);
       public List<String> getTickersFromPortfolio(String username, String portfolioName);
       public String addTickersFromPortfolio(String username, String portfolioName, String ticker);
       public String createPortfolioName(String username, String portfolioName);
	   public void deleteTickerFromPortfolio(String username, String portfolioName, String ticker);
	   public void deletePortfolioName(String username, String portfolioName);
	   public List<Record> getRecordsFromPortfolio(String username, String portfolioName);

}

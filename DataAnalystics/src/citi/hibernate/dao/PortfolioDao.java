package citi.hibernate.dao;

import java.util.List;
import java.util.Map;

public interface PortfolioDao {
       public List<String> getPortfolioName(String username);
       public List<String> getTickersFromPortfolio(String username, String portfolioName);
       public String createPortfolioName(String usrname, String portfolioName);
}

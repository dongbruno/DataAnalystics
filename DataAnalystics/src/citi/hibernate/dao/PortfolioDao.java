package citi.hibernate.dao;

import java.util.List;
import java.util.Map;

public interface PortfolioDao {
       public List<Map<String, List<String>>> getPortfolioName(String username);
       public String createPortfolioName(String usrname, String portfolioName);
}

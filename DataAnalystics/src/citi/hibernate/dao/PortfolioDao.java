package citi.hibernate.dao;

import java.util.List;

public interface PortfolioDao {
       public List<String> getPortfolioName(String username);
       public String createPortfolioName(String usrname, String portfolioName);
}

package citi.hibernate.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import citi.hibernate.dao.PortfolioDao;
@Repository
public class PortfolioDaoImpl implements PortfolioDao {
	@Override
	public List<String> getPortfolioName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createPortfolioName(String usrname, String portfolioName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getTickersFromPortfolio(String username, String portfolioName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addTickersFromPortfolio(String username, String portfolioName, String ticker) {
		// TODO Auto-generated method stub
		return null;
	}

}

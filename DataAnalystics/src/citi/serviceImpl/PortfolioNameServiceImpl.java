package citi.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import citi.hibernate.dao.PortfolioDao;
import citi.hibernate.util.HibernateUtil;
import citi.service.PortfolioNameService;
@Service
public class PortfolioNameServiceImpl implements PortfolioNameService {
	@Resource PortfolioDao portfolioDaoImpl;
	@Override
	public String createPortfolioName(String username, String portfolioName) {
		// TODO Auto-generated method stub
		HibernateUtil.openSession();
		portfolioDaoImpl.createPortfolioName(username, portfolioName);
		HibernateUtil.closeSession();
		return "success";
	}

	@Override
	public List<String> getPortfolioName(String username) {
		// TODO Auto-generated method stub
		HibernateUtil.openSession();
		List<String> portflioNames = portfolioDaoImpl.getPortfolioName(username);
		HibernateUtil.closeSession();
		return portflioNames;
	}

	@Override
	public String addTickerToPortfolio(String username, String portfolioName, String ticker) {
		// TODO Auto-generated method stub
		HibernateUtil.openSession();
		portfolioDaoImpl.addTickersFromPortfolio(username, portfolioName, ticker);
		HibernateUtil.closeSession();
		return "success";
	}

	@Override
	public List<String> getTickersFromPortfolio(String username, String portfolioName) {
		// TODO Auto-generated method stub
		HibernateUtil.openSession();
		List<String> tickersFromPortfolio = portfolioDaoImpl.getTickersFromPortfolio(username, portfolioName);
		HibernateUtil.closeSession();
		return tickersFromPortfolio;
	}

	@Override
	public String deletePortfolioName(String username, String portfolioName) {
		// TODO Auto-generated method stub
		HibernateUtil.openSession();
		portfolioDaoImpl.deletePortfolioName(username, portfolioName);
		HibernateUtil.closeSession();
		return "success";
	}

	@Override
	public String deleteTickerFromPortfolio(String username, String portfolioName, String ticker) {
		// TODO Auto-generated method stub
		HibernateUtil.openSession();
		portfolioDaoImpl.deleteTickerFromPortfolio(username, portfolioName, ticker);
		HibernateUtil.closeSession();
		return "success";
	}

}

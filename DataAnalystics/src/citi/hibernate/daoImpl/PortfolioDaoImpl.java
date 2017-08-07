package citi.hibernate.daoImpl;

import java.util.List;

import org.hibernate.Session;

import citi.hibernate.dao.PortfolioDao;
import citi.hibernate.util.HibernateUtil;
public class PortfolioDaoImpl implements PortfolioDao {
	@Override
	public List<String> getPortfolioName(String username) {

		Session sessionHibernate = HibernateUtil.getSession();
		String queryString = "select p.portfolioname from Portfolio p left join p.user u where u.username = ?";
		List<String> result = sessionHibernate.createQuery(queryString).setParameter(0, username).list();

		return result;
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

}

package citi.hibernate.daoImpl;

import java.util.List;

<<<<<<< HEAD
import org.springframework.stereotype.Repository;

import citi.hibernate.dao.PortfolioDao;
@Repository
=======
import org.hibernate.Session;

import citi.hibernate.dao.PortfolioDao;
import citi.hibernate.util.HibernateUtil;
>>>>>>> e6075bd1e87fb212586cd7d1243485772cd052e3
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

	@Override
	public String addTickersFromPortfolio(String username, String portfolioName, String ticker) {
		// TODO Auto-generated method stub
		return null;
	}

}

package citi.hibernate.daoImpl;

import java.util.List;


import org.springframework.stereotype.Repository;
import citi.hibernate.dao.PortfolioDao;
import org.hibernate.Session;
import citi.hibernate.dao.PortfolioDao;
import citi.hibernate.entity.Portfolio;
import citi.hibernate.entity.User;
import citi.hibernate.util.HibernateUtil;
public class PortfolioDaoImpl implements PortfolioDao {
	@Override
	public List<String> getPortfolioName(String username) {

		Session sessionHibernate = HibernateUtil.getSession();
		String queryString = "select p.portfolioname from Portfolio p left join p.user u where u.username = ?";
		List<String> result = sessionHibernate.createQuery(queryString).setParameter(0, username).list();

		return result;
	}
	//need to judge the portfolioname if exist
	@Override
	public String createPortfolioName(String username, String portfolioName) {

		Session sessionHibernate = HibernateUtil.getSession();
		String queryString = "select u from User u where u.username=? ";
		User user = (User) sessionHibernate.createQuery(queryString).setParameter(0, username).uniqueResult();
		sessionHibernate.beginTransaction();
		sessionHibernate.save(new Portfolio(user, portfolioName, null));
		sessionHibernate.getTransaction().commit();
		return "success";
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

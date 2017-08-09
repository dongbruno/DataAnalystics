package citi.hibernate.daoImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import citi.hibernate.dao.PortfolioDao;
import org.hibernate.Session;
import citi.hibernate.entity.Portfolio;
import citi.hibernate.entity.Record;
import citi.hibernate.entity.Stock;
import citi.hibernate.entity.User;
import citi.hibernate.util.HibernateUtil;
@Repository
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
		sessionHibernate.save(new Portfolio(user, portfolioName));
		sessionHibernate.getTransaction().commit();
		return "success";
	}
	@Override
	public List<String> getTickersFromPortfolio(String username, String portfolioName) {
		Session sessionHibernate = HibernateUtil.getSession();
		String queryString = "select p.portfolioId from Portfolio p left join p.user u where u.username=? and p.portfolioname=?";
		int pId = (int) sessionHibernate.createQuery(queryString).setParameter(0, username).setParameter(1, portfolioName).uniqueResult();
		String queryString2 = "select s.stockTicker from Stock s left join s.portfolio p where p.portfolioId=?";
		List<String> tickers = sessionHibernate.createQuery(queryString2).setParameter(0, pId).list();
		return tickers;
		
	}
	@Override
	public String addTickersFromPortfolio(String username, String portfolioName, String ticker) {
		Session sessionHibernate = HibernateUtil.getSession();
		String queryString = "select p from Portfolio p left join p.user u where p.portfolioname=? and u.username=?";
		Portfolio portfolio = (Portfolio) sessionHibernate.createQuery(queryString).setParameter(0, portfolioName).setParameter(1, username).uniqueResult();
		sessionHibernate.beginTransaction();
		sessionHibernate.save(new Stock(portfolio, ticker));
		sessionHibernate.getTransaction().commit();
		return "success";
	}
	@Override
	public void deleteTickerFromPortfolio(String username, String portfolioName, String ticker) {
		// TODO Auto-generated method stub
		Session sessionHibernate = HibernateUtil.getSession();
		String queryString = "select p.portfolioId from Portfolio p left join p.user u where u.username=? and p.portfolioname=?";
		int pId = (int) sessionHibernate.createQuery(queryString).setParameter(0, username).setParameter(1, portfolioName).uniqueResult();
		sessionHibernate.beginTransaction();
		String hql = "delete from Stock s where s.portfolio.portfolioId = ? and s.stockTicker = ? " ;     
		sessionHibernate.createQuery(hql).setParameter(0, pId).setParameter(1, ticker).executeUpdate() ;     
        sessionHibernate.getTransaction().commit();
	}
	@Override
	public void deletePortfolioName(String username, String portfolioName) {
		// TODO Auto-generated method stub
		Session sessionHibernate = HibernateUtil.getSession();
		sessionHibernate.beginTransaction();
		String hql = "delete from Portfolio p where exists(select u.userId from User u where u.username = ? and p.portfolioname = ? ) "; 
		//String hql = "delete from Portfolio p where p.user.username=? and p.portfolioname=?";
		sessionHibernate.createQuery(hql).setParameter(0, username).setParameter(1, portfolioName).executeUpdate() ;     
        sessionHibernate.getTransaction().commit();
	}
	@Override
	public List<Record> getRecordsFromPortfolio(String username, String portfolioName) {
		// TODO Auto-generated method stub
		Session sessionHibernate = HibernateUtil.getSession();
		String queryString = "select p.portfolioId from Portfolio p left join p.user u where u.username=? and p.portfolioname=?";
		int pId = (int) sessionHibernate.createQuery(queryString).setParameter(0, username).setParameter(1, portfolioName).uniqueResult();
		String queryString2 = "select s.stockTicker from Stock s left join s.portfolio p where p.portfolioId=?";
		List<String> tickers = sessionHibernate.createQuery(queryString2).setParameter(0, pId).list();
		
		List<Record> records = new ArrayList<>();
		for(String t: tickers) {
			String queryString3 = "select r from Record r where r.ticker=? and r.date =? and r.time = '1559'";
			List<Record> list1 =  sessionHibernate.createQuery(queryString3).setParameter(0, t).setParameter(1, "20160104").list();
			Record result = null;
			if(!list1.isEmpty()) {
				result = list1.get(0);
			}
			String queryString4 = "select r from Record r where r.ticker=? and r.date =? and r.time = '1559'";
			List<Record> list2 = sessionHibernate.createQuery(queryString4).setParameter(0, t).setParameter(1, "20160324").list();
			Record result2 = null;
			if(!list2.isEmpty()) {
				result2 = list2.get(0);
				}
			if(result!=null && result2!=null) {
		    	records.add(result);
			    records.add(result2);
		    }
		}
		return records;
	}
}

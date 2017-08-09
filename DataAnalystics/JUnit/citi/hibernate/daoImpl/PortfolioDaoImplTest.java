package citi.hibernate.daoImpl;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import citi.hibernate.util.HibernateUtil;

public class PortfolioDaoImplTest {

	

//	//@Test
//	public void testGetPortfolioName() {
//		PortfolioDaoImpl p = new PortfolioDaoImpl();
//		HibernateUtil.openSession();
//		System.out.println("result="+p.getPortfolioName("admin"));
//		HibernateUtil.closeSession();
//	}
//
//	@Test
//	public void testCreatePortfolioName() {
//		PortfolioDaoImpl p = new PortfolioDaoImpl();
//		HibernateUtil.openSession();
//		p.createPortfolioName("admin","risk");
//		System.out.println("result="+p.getPortfolioName("admin"));
//		HibernateUtil.closeSession();
//		
//	}

//	@Test
//	public void testGetTickersFromPortfolio() {
//		PortfolioDaoImpl p = new PortfolioDaoImpl();
//		HibernateUtil.openSession();
//		System.out.println("result2="+p.getTickersFromPortfolio("admin","risk"));
//		HibernateUtil.closeSession();
//	}
//	@Test
//	public void testAddTickersFromPortfolio() {
//		PortfolioDaoImpl p = new PortfolioDaoImpl();
//		HibernateUtil.openSession();
//		System.out.println("result="+p.addTickersFromPortfolio("admin", "haha", "d"));
//		HibernateUtil.closeSession();
//	}
	@Test
	public void deletePortfolioName() {
		PortfolioDaoImpl p = new PortfolioDaoImpl();
		HibernateUtil.openSession();
		p.deletePortfolioName("admin", "risk");
		HibernateUtil.closeSession();
	}
//	@Test
//	public void deleteTickerFromPortfolio() {
//		PortfolioDaoImpl p = new PortfolioDaoImpl();
//		HibernateUtil.openSession();
//		p.deleteTickerFromPortfolio("admin", "lele", "f");
//		HibernateUtil.closeSession();
//	}	

}

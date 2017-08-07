package citi.hibernate.daoImpl;

import static org.junit.Assert.*;

import org.junit.Test;

import citi.hibernate.util.HibernateUtil;

public class PortfolioDaoImplTest {

	
	@Test
	public void testGetPortfolioName() {

	}

	@Test
	public void testCreatePortfolioName() {
		PortfolioDaoImpl p = new PortfolioDaoImpl();
		HibernateUtil.openSession();
		p.createPortfolioName("admin","haha");
		System.out.println("result="+p.getPortfolioName("admin"));
		HibernateUtil.closeSession();
		
	}

	@Test
	public void testGetTickersFromPortfolio() {

	}

}

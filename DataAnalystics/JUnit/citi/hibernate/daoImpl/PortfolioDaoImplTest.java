package citi.hibernate.daoImpl;

import static org.junit.Assert.*;

import org.junit.Test;

public class PortfolioDaoImplTest {

	
	@Test
	public void test() {
		PortfolioDaoImpl p = new PortfolioDaoImpl();
		System.out.println("result="+p.getPortfolioName("admin"));
	}

}

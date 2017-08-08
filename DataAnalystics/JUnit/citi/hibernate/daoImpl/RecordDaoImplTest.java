package citi.hibernate.daoImpl;

import static org.junit.Assert.*;

import org.junit.Test;

import citi.hibernate.util.HibernateUtil;

public class RecordDaoImplTest {

//	@Test
//	public void testInsertRecord() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetDataBetweenDateByMinute() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGetDataBetweenDate() {
		RecordDaoImpl r = new RecordDaoImpl();
		HibernateUtil.openSession();
		System.out.println("result2="+ r.getDataBetweenDate("20160104", "20160105"));
		HibernateUtil.closeSession();
	}

//	@Test
//	public void testSearchDataBetweenDate() {
//		System.out.println("begin:--------------");
//		RecordDaoImpl r = new RecordDaoImpl();
//		HibernateUtil.openSession();
//		System.out.println("result2="+ r.searchDataBetweenDate("20160104", "20160111", "a"));
//		HibernateUtil.closeSession();	
//	}
//
//	@Test
//	public void testGetDataBetweenDateByDay() {
//		fail("Not yet implemented");
//	}

}

package citi.serviceImpl;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DateTransferServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testToDateFromString() {
		DateTransferServiceImpl dateTransferServiceImpl = new DateTransferServiceImpl();
		String string1 = dateTransferServiceImpl.toDateFromString("20160104", "903");
		String string2 = dateTransferServiceImpl.toDateFromString("20160114", "930");
		String string3 = dateTransferServiceImpl.toDateFromString("20160104", "1503");
		String string4 = dateTransferServiceImpl.toDateFromString("20160104", "0");
		assertTrue("2016-01-04 09:03".equals(string1));
		assertTrue("2016-01-14 09:30".equals(string2));
		assertTrue("2016-01-04 15:03".equals(string3));
		assertTrue("2016-01-04".equals(string4));
	}

	@Test
	public void testToListFromDate() {
		DateTransferServiceImpl dateTransferServiceImpl = new DateTransferServiceImpl();
		List<String> dates1 = dateTransferServiceImpl.toListFromDate("2016-01-04 09:03");
		List<String> dates2 = dateTransferServiceImpl.toListFromDate("2016-01-14 09:30");
		List<String> dates3 = dateTransferServiceImpl.toListFromDate("2016-01-04 15:03");
		List<String> dates4 = dateTransferServiceImpl.toListFromDate("2016-01-04");
		assertTrue(dates1.get(0).equals("20160104"));
		assertTrue(dates1.get(1).equals("903"));
		assertTrue(dates2.get(0).equals("20160114"));
		assertTrue(dates2.get(1).equals("930"));
		assertTrue(dates3.get(0).equals("20160104"));
		assertTrue(dates3.get(1).equals("1503"));
		assertTrue(dates4.get(0).equals("20160104"));
		assertTrue(dates4.get(1).equals("0"));
	}
	
	@Test
	public void testTurnLastDay() {
		String dateNow1 = "20160201";
		String dateNow2 = "20160305";
		String dateNow3 = "20160215";
		String dateNow4 = "20160301";
		String dateNow5 = "20160401";
		String dateNow6 = "20160430";
		String dateNow7 = "20160531";
		DateTransferServiceImpl dateTransferServiceImpl = new DateTransferServiceImpl();
		String date1 = dateTransferServiceImpl.turnLastDay(dateNow1);
		String date2 = dateTransferServiceImpl.turnLastDay(dateNow2);
		String date3 = dateTransferServiceImpl.turnLastDay(dateNow3);
		String date4 = dateTransferServiceImpl.turnLastDay(dateNow4);
		String date5 = dateTransferServiceImpl.turnLastDay(dateNow5);
		String date6 = dateTransferServiceImpl.turnLastDay(dateNow6);
		String date7 = dateTransferServiceImpl.turnLastDay(dateNow7);
		assertTrue(date1.equals("20160131"));
		assertTrue(date2.equals("20160304"));
		assertTrue(date3.equals("20160214"));
		assertTrue(date4.equals("20160229"));
		assertTrue(date5.equals("20160331"));
		assertTrue(date6.equals("20160429"));
		assertTrue(date7.equals("20160530"));
	}

}

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
		assertTrue("2016-01-04 09:03".equals(string1));
		assertTrue("2016-01-14 09:30".equals(string2));
		assertTrue("2016-01-04 15:03".equals(string3));
	}

	@Test
	public void testToListFromDate() {
		DateTransferServiceImpl dateTransferServiceImpl = new DateTransferServiceImpl();
		List<String> dates1 = dateTransferServiceImpl.toListFromDate("2016-01-04 09:03");
		List<String> dates2 = dateTransferServiceImpl.toListFromDate("2016-01-14 09:30");
		List<String> dates3 = dateTransferServiceImpl.toListFromDate("2016-01-04 15:03");
		assertTrue(dates1.get(0).equals("20160104"));
		assertTrue(dates1.get(1).equals("903"));
		assertTrue(dates2.get(0).equals("20160114"));
		assertTrue(dates2.get(1).equals("930"));
		assertTrue(dates3.get(0).equals("20160104"));
		assertTrue(dates3.get(1).equals("1503"));
	}

}

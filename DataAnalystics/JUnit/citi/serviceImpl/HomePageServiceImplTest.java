package citi.serviceImpl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import citi.hibernate.entity.Record;

public class HomePageServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@SuppressWarnings("null")
	@Test
	public void testSearchDataBetweenDate() {
		Record record1 = new Record("a", "20160104", "930", 41.08, 41.08,
				41.04, 41.06, 990);
		Record record2 = new Record("a", "20160105", "9301", 40.92, 41.06,
				40.92, 41.06, 13);
		Record record3 = new Record("aa", "20160104", "930", 9.479, 9.489,
				9.4292, 9.4591, 34525);
		Record record4 = new Record("aa", "20160105", "9301", 9.4591, 9.4691,
				9.4093, 9.4392, 732559);
		Record record5 = new Record("aal", "20160104", "930", 40.9782, 41.1776,
				40.6491, 40.6491, 468172);
		Record record6 = new Record("aal", "20160105", "931", 40.6491, 40.7089,
				40.5892, 40.6391, 70568);
		ArrayList<Record> records = new ArrayList<Record>();
		records.add(record1);
		records.add(record2);
		records.add(record3);
		records.add(record4);
		records.add(record5);
		records.add(record6);
		int i = 0;
		Record recordStart = null;
		Record recordEnd = null;
		ArrayList<HashMap<String, Object>> recordDate = new ArrayList<HashMap<String, Object>>();
		while (i < records.size() - 1) {
			recordStart = records.get(i);
			recordEnd = records.get(i + 1);
			String ticker = recordStart.getTicker();
			Double open = recordStart.getClose();
			Double close = recordEnd.getClose();
			Double changePersent = (close - open) / open;
			DecimalFormat df = new DecimalFormat("#0.00");
			String changePerc = null;
			if (close >= open) {
				changePerc = df.format(changePersent * 100) + "%";
			} else {
				changePerc = "-" + df.format((-changePersent) * 100) + "%";
			} 
			String change = new BigDecimal(String.valueOf(open)).subtract(new BigDecimal(String.valueOf(close))).toString();
			HashMap<String, Object> record = new HashMap<String, Object>();
			record.put("ticker", ticker);
			record.put("open", open);
			record.put("close", close);
			record.put("changepercent", changePerc);
			record.put("change", change);
			i = i + 2;
			recordDate.add(record);
		}
		System.out.println("ticker: a");
		System.out.println(recordDate.get(0).get("ticker"));
		System.out.println(recordDate.get(0).get("open"));
		System.out.println(recordDate.get(0).get("close"));
		System.out.println(recordDate.get(0).get("changepercent"));
		System.out.println(recordDate.get(0).get("change"));
		System.out.println("ticker: aa");
		System.out.println(recordDate.get(1).get("ticker"));
		System.out.println(recordDate.get(1).get("open"));
		System.out.println(recordDate.get(1).get("close"));
		System.out.println(recordDate.get(1).get("changepercent"));
		System.out.println(recordDate.get(1).get("change"));
		System.out.println("ticker: aal");
		System.out.println(recordDate.get(2).get("ticker"));
		System.out.println(recordDate.get(2).get("open"));
		System.out.println(recordDate.get(2).get("close"));
		System.out.println(recordDate.get(2).get("changepercent"));
		System.out.println(recordDate.get(2).get("change"));
	}

	@Test
	public void testGetDataBetweenDate() {

	}

}

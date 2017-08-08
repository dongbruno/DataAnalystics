package citi.serviceImpl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import citi.hibernate.dao.RecordDao;
import citi.hibernate.entity.Record;
import citi.hibernate.util.HibernateUtil;
import citi.service.DateTransferService;
import citi.service.HomePageService;

@Service
public class HomePageServiceImpl implements HomePageService {
	@Resource
	DateTransferService DateTransferServiceImpl;
	@Resource
	RecordDao recordDaoImpl;

	@Override
	public ArrayList<HashMap<String, Object>> searchDataBetweenDate(
			String fromDate, String toDate, String ticker) {
		// TODO Auto-generated method stub
		String start = DateTransferServiceImpl.toListFromDate(fromDate).get(0);
		String end = DateTransferServiceImpl.toListFromDate(toDate).get(0);
		HibernateUtil.openSession();
		List<Record> records = recordDaoImpl.searchDataBetweenDate(start, end,ticker);
		HibernateUtil.closeSession();
		int i = 0;
		Record recordStart = null;
		Record recordEnd = null;
		ArrayList<HashMap<String, Object>> recordDate = new ArrayList<HashMap<String, Object>>();
		while (i < records.size() - 1) {
			recordStart = records.get(i);
			recordEnd = records.get(i + 1);
			String tickerName = recordStart.getTicker();
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
			record.put("ticker", tickerName);
			record.put("open", open);
			record.put("close", close);
			record.put("changepercent", changePerc);
			record.put("change", change);
			i = i + 2;
			recordDate.add(record);
		}
		return recordDate;
	}

	@Override
	public ArrayList<HashMap<String, Object>> getDataBetweenDate(
			String fromDate, String toDate) {
		// TODO Auto-generated method stub
		String start = DateTransferServiceImpl.toListFromDate(fromDate).get(0);
		String end = DateTransferServiceImpl.toListFromDate(toDate).get(0);
		System.out.println(start+"--"+end);
		HibernateUtil.openSession();
		List<Record> records = recordDaoImpl.getDataBetweenDate(start, end);
		HibernateUtil.closeSession();
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
		return recordDate;
	}

}

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
import citi.hibernate.entity.TempRecord;
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
	public List<TempRecord> searchDataBetweenDate(
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
		List<TempRecord> recordDate = new ArrayList<TempRecord>();
		String tickerName;
		Double open;
		Double close;
		Double changePersent;
		String changePerc;
		DecimalFormat df;
		String change;
		while (i < records.size() - 1) {
			recordStart = records.get(i);
			recordEnd = records.get(i + 1);
			tickerName = recordStart.getTicker();
			open = recordStart.getClose();
			close = recordEnd.getClose();
			changePersent = (close - open) / open;
			df = new DecimalFormat("#0.00");
			if (close >= open) {
				changePerc = df.format(changePersent * 100) + "%";
			} else {
				changePerc = "-" + df.format((-changePersent) * 100) + "%";
			} 
		    change = new BigDecimal(String.valueOf(open)).subtract(new BigDecimal(String.valueOf(close))).toString();
			i = i + 2;
			recordDate.add(new TempRecord(tickerName, open, close, changePerc, change));
		}
		return recordDate;
	}

	@Override
	public List<TempRecord> getDataBetweenDate(
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
		List<TempRecord> recordDate = new ArrayList<TempRecord>();
		String ticker;
		Double open;
		Double close;
		Double changePersent;
		String changePerc;
		DecimalFormat df;
		String change;
		while (i < records.size() - 1) {
			recordStart = records.get(i);
			recordEnd = records.get(i + 1);
			ticker = recordStart.getTicker();
			open = recordStart.getClose();
			close = recordEnd.getClose();
			changePersent = (close - open) / open;
			df = new DecimalFormat("#0.00");
			if (close >= open) {
				changePerc = df.format(changePersent * 100) + "%";
			} else {
				changePerc = "-" + df.format((-changePersent) * 100) + "%";
			} 
			change = new BigDecimal(String.valueOf(open)).subtract(new BigDecimal(String.valueOf(close))).toString();
			i = i + 2;
			recordDate.add(new TempRecord(ticker, open, close, changePerc, change));
		}
		return recordDate;
	}

}

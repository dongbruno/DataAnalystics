package citi.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import citi.hibernate.dao.RecordDao;
import citi.hibernate.entity.Record;
import citi.hibernate.util.HibernateUtil;
import citi.service.DateTransferService;
import citi.service.KLineChartService;
@Service
public class KLineChartServiceImpl implements KLineChartService {
	@Resource
	DateTransferService dateTransferServiceImpl;
	@Resource
	RecordDao recordDaoImpl;
	@Override
	public List<Record> getDataBetweenDateByDay(String fromDate, String toDate, String ticker) {
		// TODO Auto-generated method stub
		String start = dateTransferServiceImpl.toListFromDate(fromDate).get(0);
		String end = dateTransferServiceImpl.toListFromDate(toDate).get(0);
		HibernateUtil.openSession();
		List<Record> records = recordDaoImpl.getDataBetweenDateByDay(start, end, ticker);
		HibernateUtil.closeSession();
		for(Record r :records) {
			r.setDate(dateTransferServiceImpl.toDateFromString(r.getDate(), ""));
			r.setTime(dateTransferServiceImpl.toDateFromString("", r.getTime()));
		}
		return records;
	}
	@Override
	public List<Record> getDataBetweenDateByMinute(String fromDate, String toDate, String ticker) {
		// TODO Auto-generated method stub
		HibernateUtil.openSession();
		List<Record> records = recordDaoImpl.getDataBetweenDateByMinute(fromDate, toDate, ticker);
		HibernateUtil.closeSession();
		for(Record r :records) {
			r.setDate(dateTransferServiceImpl.toDateFromString(r.getDate(), ""));
			r.setTime(dateTransferServiceImpl.toDateFromString("", r.getTime()));
		}
		return records;
	}
}

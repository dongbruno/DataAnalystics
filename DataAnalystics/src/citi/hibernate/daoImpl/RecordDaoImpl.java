package citi.hibernate.daoImpl;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import citi.hibernate.dao.RecordDao;
import citi.hibernate.entity.Record;
import citi.hibernate.util.HibernateUtil;
import citi.service.DateTransferService;
@Repository
public class RecordDaoImpl implements RecordDao {
@Resource DateTransferService dateTransferServiceImpl;
	@Override
	public void insertRecord(Record record) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		System.out.println("session="+session);
		session.beginTransaction();
		session.save(record);
		session.getTransaction().commit();
	}
	@Override
	public List<Record> getDataBetweenDateByMinute(String fromDate, String toDate, String ticker) {
		// TODO Auto-generated method stub
	    List<String> start = dateTransferServiceImpl.toListFromDate(fromDate);
	    String startDate = start.get(0);
	    String startTime = start.get(1);
	    List<String> end = dateTransferServiceImpl.toListFromDate(toDate);
	    String endDate = end.get(0);
	    String endTime = end.get(1);
		Session sessionHibernate = HibernateUtil.getSession();
		String queryString2 = "select new Record(r.ticker, r.date, r.time, r.open, r.high,r.low,r.close,r.volume) from Record r where r.ticker=? and r.date>=? and r.date<=? and r.time>=? and r.time<=?";
		List<Record> records =  sessionHibernate.createQuery(queryString2).setParameter(0, ticker).setParameter(1, startDate).setParameter(2, endDate).setParameter(3, startTime).setParameter(4, endTime).list();
		return records;
	}
	@Override
	public List<Record> getDataBetweenDate(String start, String end) {
		// TODO Auto-generated method stub
		Session sessionHibernate = HibernateUtil.getSession();
		String queryString = "select distinct r.ticker from Record r";
		List<String> tickers = sessionHibernate.createQuery(queryString).setFirstResult(0).setMaxResults(10).list();
		List<Record> records = new ArrayList<>();
		for(String ticker: tickers) {
			String queryString2 = "select new Record(r.ticker, r.date, r.time, r.open, r.high,r.low,r.close,r.volume) from Record r where r.ticker=? and r.date =? and r.time = '1559'";
			List<Record> list1 = sessionHibernate.createQuery(queryString2).setParameter(0, ticker).setParameter(1, start).list();
			Record result = null;
			if(!list1.isEmpty()) {
				result = list1.get(0);
			}
			String queryString3 = "select new Record(r.ticker, r.date, r.time, r.open, r.high,r.low,r.close,r.volume) from Record r where r.ticker=? and r.date =? and r.time = '1559'";
			List<Record> list2 = sessionHibernate.createQuery(queryString3).setParameter(0, ticker).setParameter(1, end).list();
			Record result2 = null;
			if(!list2.isEmpty()) {
				result2 = list2.get(0);
				}
		    if(result!=null && result2!=null) {
		    	records.add(result);
			    records.add(result2);
		    }
		}
		return records;
	}
	@Override
	public List<Record> searchDataBetweenDate(String start, String end, String ticker) {
		// TODO Auto-generated method stub
		Session sessionHibernate = HibernateUtil.getSession();
		String queryString = "select distinct r.ticker from Record r where r.ticker like :name";
		List<String> tickers = sessionHibernate.createQuery(queryString).setString("name", "%"+ticker+"%").list();
		List<Record> records = new ArrayList<>();
		for(String t: tickers) {
			String queryString2 = "select new Record(r.ticker, r.date, r.time, r.open, r.high,r.low,r.close,r.volume) from Record r where r.ticker=? and r.date =? and r.time = '1559'";
			List<Record> list1 =  sessionHibernate.createQuery(queryString2).setParameter(0, t).setParameter(1, start).list();
			Record result = null;
			if(!list1.isEmpty()) {
				result = list1.get(0);
			}
			String queryString3 = "select new Record(r.ticker, r.date, r.time, r.open, r.high,r.low,r.close,r.volume) from Record r where r.ticker=? and r.date =? and r.time = '1559'";
			List<Record> list2 = sessionHibernate.createQuery(queryString3).setParameter(0, t).setParameter(1, end).list();
			Record result2 = null;
			if(!list2.isEmpty()) {
				result2 = list2.get(0);
				}
			if(result!=null && result2!=null) {
		    	records.add(result);
			    records.add(result2);
		    }
		}
		return records;
	}
	@Override
	public List<Record> getDataBetweenDateByDay(String start, String end, String ticker) {
		// TODO Auto-generated method stub
		Session sessionHibernate = HibernateUtil.getSession();
		String queryString2 = "select new Record(r.ticker, r.date, r.time, r.open, r.high,r.low,r.close,r.volume) from Record r where r.ticker=? and r.date>=? and r.date<=? and r.time = '1559'";
		List<Record> records =  sessionHibernate.createQuery(queryString2).setParameter(0, ticker).setParameter(1, start).setParameter(2, end).list();
		return records;
	}
}

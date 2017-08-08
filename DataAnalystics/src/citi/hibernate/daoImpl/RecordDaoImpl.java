package citi.hibernate.daoImpl;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import citi.hibernate.dao.RecordDao;
import citi.hibernate.entity.Record;
import citi.hibernate.util.HibernateUtil;
@Repository
public class RecordDaoImpl implements RecordDao {

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
	public List<Object> getDataBetweenDateByMinute(String fromDate, String toDate, String ticker) {
		// TODO Auto-generated method stub
		return null;
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
			Record result = (Record) sessionHibernate.createQuery(queryString2).setParameter(0, ticker).setParameter(1, start).uniqueResult();
			String queryString3 = "select new Record(r.ticker, r.date, r.time, r.open, r.high,r.low,r.close,r.volume) from Record r where r.ticker=? and r.date =? and r.time = '1559'";
			Record result2 = (Record) sessionHibernate.createQuery(queryString3).setParameter(0, ticker).setParameter(1, end).uniqueResult();
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
			Record result = (Record) sessionHibernate.createQuery(queryString2).setParameter(0, t).setParameter(1, start).uniqueResult();
			String queryString3 = "select new Record(r.ticker, r.date, r.time, r.open, r.high,r.low,r.close,r.volume) from Record r where r.ticker=? and r.date =? and r.time = '1559'";
			Record result2 = (Record) sessionHibernate.createQuery(queryString3).setParameter(0, t).setParameter(1, end).uniqueResult();
		    if(result!=null && result2!=null) {
		    	records.add(result);
			    records.add(result2);
		    }
		}
		return records;
	}

	@Override
	public List<Object> getDataBetweenDateByDay(int start, int end, String ticker) {
		// TODO Auto-generated method stub
		
		return null;
	}

	

	

}

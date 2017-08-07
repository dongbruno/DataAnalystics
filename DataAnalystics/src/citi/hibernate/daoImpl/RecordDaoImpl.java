package citi.hibernate.daoImpl;


import java.util.List;
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
	public List<Object> searchDataBetweenDate(String fromDate, String toDate, String ticker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getDataBetweenDate(String fromDate, String toDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getDataBetweenDateByDay(String fromDate, String toDate, String ticker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getDataBetweenDateByMinute(String fromDate, String toDate, String ticker) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

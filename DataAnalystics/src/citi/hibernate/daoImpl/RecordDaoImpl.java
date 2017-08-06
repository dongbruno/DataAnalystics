package citi.hibernate.daoImpl;


import org.hibernate.Session;

import citi.hibernate.dao.RecordDao;
import citi.hibernate.entity.Record;
import citi.hibernate.util.HibernateUtil;

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

	

}

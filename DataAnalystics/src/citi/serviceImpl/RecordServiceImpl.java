package citi.serviceImpl;

import citi.hibernate.dao.RecordDao;
import citi.hibernate.daoImpl.RecordDaoImpl;
import citi.hibernate.entity.Record;
import citi.hibernate.util.HibernateUtil;
import citi.service.RecordService;
public class RecordServiceImpl implements RecordService {
	
	@Override
	public String insertRecord(Record record) {
		// TODO Auto-generated method stub
		 RecordDao recordDaoImpl = new RecordDaoImpl();
		 HibernateUtil.openSession();
		 recordDaoImpl.insertRecord(record);
         HibernateUtil.closeSession();
         return "sucess";
	}
}

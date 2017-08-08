package citi.serviceImpl;

import javax.annotation.Resource;

import citi.hibernate.dao.RecordDao;
import citi.hibernate.daoImpl.RecordDaoImpl;
import citi.hibernate.entity.Record;
import citi.hibernate.util.HibernateUtil;
import citi.service.RecordService;
public class RecordServiceImpl implements RecordService {
	@Resource RecordDao recordDaoImpl;
	@Override
	public String insertRecord(Record record) {
		// TODO Auto-generated method stub
		 HibernateUtil.openSession();
		 recordDaoImpl.insertRecord(record);
         HibernateUtil.closeSession();
         return "sucess";
	}
}

package citi.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import citi.hibernate.dao.RecordDao;
import citi.hibernate.entity.Record;
import citi.service.DateTransferService;
import citi.service.HomePageService;
@Service
public class HomePageServiceImpl implements HomePageService {
	@Resource DateTransferService DateTransferServiceImpl;
	@Resource RecordDao recordDaoImpl;
	@Override
	public List<Object> searchDataBetweenDate(String fromDate, String toDate, String ticker) {
		// TODO Auto-generated method stub
		String start = DateTransferServiceImpl.toListFromDate(fromDate).get(0);
		String end = DateTransferServiceImpl.toListFromDate(toDate).get(0);
		return null;
	}

	@Override
	public List<Object> getDataBetweenDate(String fromDate, String toDate) {
		// TODO Auto-generated method stub
		String start = DateTransferServiceImpl.toListFromDate(fromDate).get(0);
		String end = DateTransferServiceImpl.toListFromDate(toDate).get(0);
		List<Record> records = recordDaoImpl.getDataBetweenDate(start, end);
		return null;
	}

	

}

package citi.hibernate.dao;

import java.util.List;

import citi.hibernate.entity.Record;

public interface RecordDao {
	public void insertRecord(Record record);
	public List<Object> searchDataBetweenDate(String fromDate, String toDate, String ticker);
	public List<Object> getDataBetweenDate(String fromDate, String toDate);
	public List<Object> getDataBetweenDateByDay(String fromDate, String toDate, String ticker);
	public List<Object> getDataBetweenDateByMinute(String fromDate, String toDate, String ticker);
}

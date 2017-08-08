package citi.hibernate.dao;

import java.util.List;

import citi.hibernate.entity.Record;

public interface RecordDao {
	public void insertRecord(Record record);
	public List<Object> searchDataBetweenDate(String start, String end, String ticker);
	public List<Record> getDataBetweenDate(String start, String end);
	public List<Object> getDataBetweenDateByDay(int start, int end, String ticker);
	public List<Object> getDataBetweenDateByMinute(String fromDate, String toDate, String ticker);
}

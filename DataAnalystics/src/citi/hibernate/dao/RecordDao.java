package citi.hibernate.dao;

import java.util.List;

import citi.hibernate.entity.Record;

public interface RecordDao {
	public void insertRecord(Record record);
	public List<Record> searchDataBetweenDate(String start, String end, String ticker);
	public List<Record> getDataBetweenDate(String start, String end);
	public List<Record> getDataBetweenDateByDay(String start, String end, String ticker);
	public List<Record> getDataBetweenDateByMinute(String fromDate, String toDate, String ticker);
}

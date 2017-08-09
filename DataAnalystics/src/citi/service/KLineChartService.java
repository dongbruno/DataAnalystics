package citi.service;

import java.util.List;

import citi.hibernate.entity.Record;

public interface KLineChartService {
	public List<Record> getDataBetweenDateByDay(String fromDate, String toDate, String ticker);
	public List<Record> getDataBetweenDateByMinute(String fromDate, String toDate, String ticker);
}

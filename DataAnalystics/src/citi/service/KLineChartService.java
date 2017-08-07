package citi.service;

import java.util.List;

public interface KLineChartService {
	public List<Object> getDataBetweenDateByDay(String fromDate, String toDate, String ticker);
	public List<Object> getDataBetweenDateByMinute(String fromDate, String toDate, String ticker);
}

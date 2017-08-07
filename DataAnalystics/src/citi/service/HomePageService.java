package citi.service;

import java.util.List;

public interface HomePageService {

	public List<Object> searchDataBetweenDate(String fromDate, String toDate, String ticker);
	public List<Object> getDataBetweenDate(String fromDate, String toDate);

}

package citi.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface HomePageService {

	public ArrayList<HashMap<String, Object>> searchDataBetweenDate(String fromDate, String toDate, String ticker);
	public ArrayList<HashMap<String, Object>> getDataBetweenDate(String fromDate, String toDate);

}

package citi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import citi.hibernate.entity.TempRecord;

public interface HomePageService {

	public List<TempRecord> searchDataBetweenDate(String fromDate, String toDate, String ticker);
	public List<TempRecord> getDataBetweenDate(String fromDate, String toDate);

}

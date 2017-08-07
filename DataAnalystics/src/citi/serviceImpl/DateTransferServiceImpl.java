package citi.serviceImpl;

import java.util.List;

import citi.service.DateTransferService;

public class DateTransferServiceImpl implements DateTransferService {

	@Override
	public String toDateFromString(String DBdate, String DBtime) {
		// TODO Auto-generated method stub
		String date = DBdate.substring(0, 4) + "-" + DBdate.substring(4, 6)
				+ "-" + DBdate.substring(6);
		String time = null;
		if (DBtime.length() == 3) {
			time = DBtime.substring(0, 1) + ":" + DBtime.substring(1);
		} else {
			time = DBtime.substring(0, 2) + ":" + DBtime.substring(2);
		}
		String dateAll = date + " " + time;
		return dateAll;
	}

	@SuppressWarnings("null")
	@Override
	public List<String> toListFromDate(String date) {
		// TODO Auto-generated method stub
		String[] dates = date.split(" ");
		String[] dmy = dates[0].split("-");
		String[] smh = dates[1].split(":");
		String DBdate = dmy[0] + dmy[1] + dmy[2];
		String DBtime = smh[0] + smh[1];
		List<String> DBTime = null;
		DBTime.add(DBdate);
		DBTime.add(DBtime);
		return DBTime;
	}

}

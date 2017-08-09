package citi.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import citi.service.DateTransferService;

@Service
public class DateTransferServiceImpl implements DateTransferService {

	@Override
	public String toDateFromString(String DBdate, String DBtime) {
		// TODO Auto-generated method stub
		String date = DBdate.substring(0, 4) + "-" + DBdate.substring(4, 6)
				+ "-" + DBdate.substring(6);
		String time = null;
		String dateAll = null;
		if (!DBtime.equals("0")) {
			if (DBtime.length() == 3) {
				time = "0" + DBtime.substring(0, 1) + ":" + DBtime.substring(1);
			} else {
				time = DBtime.substring(0, 2) + ":" + DBtime.substring(2);
			}
			dateAll = date + " " + time;
		} else {
			dateAll = date;
		}
		return dateAll;
	}

	@Override
	public List<String> toListFromDate(String date) {
		// TODO Auto-generated method stub
		String adate = null;
		String atime = null;
		if (date.length() > 10) {
			String[] dates = date.split(" ");
			String[] dmy = dates[0].split("-");
			adate = dmy[0] + dmy[1] + dmy[2];
			atime = null;
			String[] smh = dates[1].split(":");
			if (smh[0].substring(0, 1).equals("0")) {
				atime = smh[0].substring(1) + smh[1];
			} else {
				atime = smh[0] + smh[1];
			}
		} else {
			String[] dmy = date.split("-");
			adate = dmy[0] + dmy[1] + dmy[2];
			atime = "0";
		}
		ArrayList<String> DBdate = new ArrayList<String>();
		DBdate.add(adate);
		DBdate.add(atime);
		return DBdate;
	}

	@Override
	public String turnLastDay(String now) {
		// TODO Auto-generated method stub
		int year = Integer.parseInt(now.substring(0, 4));
		int month = Integer.parseInt(now.substring(4, 6));
		int day = Integer.parseInt(now.substring(6, 8));
		String monthStr = null;
		String dayStr = null;
		if (day > 1) {
			day = day - 1;
		} else if (month == 2 || month == 4 || month == 6
				|| month == 8 || month == 9 || month == 11) {
			month = month - 1;
			day = 31;
		} else if (month == 5 || month == 7 || month == 10 || month == 12) {
			month = month - 1;
			day = 30;
		} else if (month == 3) {
			month = month - 1;
			day = 29;
		} else if (month == 1) {
			month = 12;
		}
		if (month < 10) {
			monthStr = "0" + String.valueOf(month);
		} else {
			monthStr = String.valueOf(month);
		}
		if (day < 10) {
			dayStr = "0" + String.valueOf(day);
		} else {
			dayStr = String.valueOf(day);
		}
		return year + monthStr + dayStr;
	}

}

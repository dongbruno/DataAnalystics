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

	@SuppressWarnings("null")
	@Override
	public List<String> toListFromDate(String date) {
		// TODO Auto-generated method stub
		String adate = null;
		String atime = null;
		if (date.length()>10) {
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

}

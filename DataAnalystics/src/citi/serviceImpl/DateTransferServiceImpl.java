package citi.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import citi.service.DateTransferService;

public class DateTransferServiceImpl implements DateTransferService {

	@Override
	public String toDateFromString(String date, String time) {
		// TODO Auto-generated method stub
		String adate = date.substring(0, 4) + "-" + date.substring(4, 6) + "-"
				+ date.substring(6);
		String atime = null;
		if (time.length() == 3) {
			atime = "0" + time.substring(0, 1) + ":" + time.substring(1);
		} else {
			atime = time.substring(0, 2) + ":" + time.substring(2);
		}
		return adate + " " + atime;
	}

	@Override
	public List<String> toListFromDate(String date) {
		// TODO Auto-generated method stub
		String[] dates = date.split(" ");
		String[] dmy = dates[0].split("-");
		String[] smh = dates[1].split(":");
		String adate = dmy[0] + dmy[1] + dmy[2];
		String atime = null;
		if (smh[0].substring(0,1).equals("0")) {
			atime = smh[0].substring(1) + smh[1];
		} else {
			atime = smh[0] + smh[1];
		}
		ArrayList<String> DBdate = new ArrayList<String>();
		DBdate.add(adate);
		DBdate.add(atime);
		return DBdate;
	}

}

package citi.service;

import java.util.List;

public interface DateTransferService {
       public String toDateFromString(String date, String time);
       public List<String> toListFromDate(String date);
}

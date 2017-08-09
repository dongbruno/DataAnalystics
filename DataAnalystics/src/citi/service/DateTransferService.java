package citi.service;

import java.util.List;

public interface DateTransferService {
       public String toDateFromString(String date, String time);
       public List<String> toListFromDate(String date);
       public String turnLastDay(String now);
}

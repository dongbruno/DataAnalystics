package citi.controller;

import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import citi.service.KLineChartService;
@Controller
public class KLineChartController {
	@Resource
	KLineChartService kLineChartServiceImpl;
	@RequestMapping(value = "/getDataBetweenDateByDay/{fromDate}/{toDate}/{ticker}", method = RequestMethod.GET)
	@ResponseBody
	public List<Object> getDataBetweenDateByDay(@PathVariable String fromDate, @PathVariable String toDate, @PathVariable String ticker) 
			throws IOException{
		List<Object> result = kLineChartServiceImpl.getDataBetweenDateByDay(fromDate, toDate, ticker);
		return  result;
	}
	@RequestMapping(value = "/getDataBetweenDateByMinute/{fromDate}/{toDate}/{ticker}", method = RequestMethod.GET)
	@ResponseBody
	public List<Object> getDataBetweenDateByMinute(@PathVariable String fromDate, @PathVariable String toDate, @PathVariable String ticker) 
			throws IOException{
		List<Object> result = kLineChartServiceImpl.getDataBetweenDateByMinute(fromDate, toDate, ticker);
		return  result;
	}
}

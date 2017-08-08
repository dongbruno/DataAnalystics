package citi.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import citi.service.HomePageService;
@Controller
public class HomePageController {
	@Resource HomePageService homePageServiceImpl;
	private static final Log logger = LogFactory.getLog( HomePageController.class);
	@RequestMapping(value = "/getDataBetweenDate/{fromDate}/{toDate}", method = RequestMethod.GET)
	@ResponseBody
	public List<HashMap<String, Object>> getDataBetweenDate(@PathVariable String fromDate, @PathVariable String toDate) 
			throws IOException{
		List<HashMap<String, Object>> result = homePageServiceImpl.getDataBetweenDate(fromDate, toDate);
		System.out.println("hello");
		return  result;
	}
	@RequestMapping(value = "/SearchDataBetweenDate/{fromDate}/{toDate}/ticker", method = RequestMethod.GET)
	@ResponseBody
	public List<HashMap<String, Object>> getDataBetweenDate(@PathVariable String fromDate, @PathVariable String toDate, @PathVariable String ticker) 
			throws IOException{
		List<HashMap<String,Object>> result = homePageServiceImpl.searchDataBetweenDate(fromDate, toDate,ticker);
		return  result;
	}

}
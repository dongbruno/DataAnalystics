package citi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import citi.hibernate.entity.Record;
import citi.service.PortfolioNameService;
@Controller
public class PortfolioNameController {
	@Resource PortfolioNameService portfolioNameServiceImpl;
	private static final Log logger = LogFactory.getLog( HomePageController.class);
	@RequestMapping(value = "/createPortfolioName", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> createPortfolioName(@RequestParam String username, @RequestParam String portfolioName){
		String result = portfolioNameServiceImpl.createPortfolioName(username, portfolioName);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", result);
		return map;
	}
	@RequestMapping(value = "/getPortfolioName", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, String>> getPortfolioName(@RequestParam String username){
		List<Map<String, String>> result = new ArrayList<Map<String,String>>();
		List<String> portfolios = portfolioNameServiceImpl.getPortfolioName(username);
		for(String str: portfolios) {
			Map<String, String> m = new HashMap<String,String>();
			List<String> tickers = portfolioNameServiceImpl.getTickersFromPortfolio(username, str);
			m.put("portfolioname", str);
			String quantity = ""+tickers.size();
			m.put("quantity", quantity);
			result.add(m);
		}
		return result;
	}
	@RequestMapping(value = "/getRecordsFromPortfolio", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<HashMap<String, Object>> getRecordsFromPortfolio(@RequestParam String username, @RequestParam String portfolioName){
		ArrayList<HashMap<String, Object>> result = portfolioNameServiceImpl.getRecordsFromPortfolio(username, portfolioName);
		return result;
	}
	@RequestMapping(value = "/addTickerToPortfolio", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> addTickerToPortfolio(@RequestParam String username, @RequestParam String portfolioName, @RequestParam String ticker){
		String result = portfolioNameServiceImpl.addTickerToPortfolio(username, portfolioName, ticker);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", result);
		return map;
	}
	@RequestMapping(value = "/deletePortfolioName", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> deletePortfolioName(@RequestParam String username, @RequestParam String portfolioName){
		String result = portfolioNameServiceImpl.deletePortfolioName(username, portfolioName);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", result);
		return map;
	}
	@RequestMapping(value = "/deleteTickerFromPortfolio", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> deleteTickerFromPortfolio(@RequestParam String username, @RequestParam String portfolioName, @RequestParam String ticker){
		String result = portfolioNameServiceImpl.deleteTickerFromPortfolio(username, portfolioName, ticker);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", result);
		return map;
	}
}

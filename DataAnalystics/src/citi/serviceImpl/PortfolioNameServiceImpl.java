package citi.serviceImpl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import citi.hibernate.dao.PortfolioDao;
import citi.hibernate.entity.Record;
import citi.hibernate.util.HibernateUtil;
import citi.service.PortfolioNameService;
@Service
public class PortfolioNameServiceImpl implements PortfolioNameService {
	@Resource PortfolioDao portfolioDaoImpl;
	@Override
	public String createPortfolioName(String username, String portfolioName) {
		// TODO Auto-generated method stub
		HibernateUtil.openSession();
		portfolioDaoImpl.createPortfolioName(username, portfolioName);
		HibernateUtil.closeSession();
		return "success";
	}

	@Override
	public List<String> getPortfolioName(String username) {
		// TODO Auto-generated method stub
		HibernateUtil.openSession();
		List<String> portflioNames = portfolioDaoImpl.getPortfolioName(username);
		HibernateUtil.closeSession();
		return portflioNames;
	}

	@Override
	public String addTickerToPortfolio(String username, String portfolioName, String ticker) {
		// TODO Auto-generated method stub
		HibernateUtil.openSession();
		portfolioDaoImpl.addTickersFromPortfolio(username, portfolioName, ticker);
		HibernateUtil.closeSession();
		return "success";
	}

	@Override
	public ArrayList<HashMap<String, Object>> getRecordsFromPortfolio(String username, String portfolioName) {
		// TODO Auto-generated method stub
		HibernateUtil.openSession();
		List<Record> records = portfolioDaoImpl.getRecordsFromPortfolio(username, portfolioName);
		HibernateUtil.closeSession();
		int i = 0;
		Record recordStart = null;
		Record recordEnd = null;
		ArrayList<HashMap<String, Object>> recordDate = new ArrayList<HashMap<String, Object>>();
		while (i < records.size() - 1) {
			recordStart = records.get(i);
			recordEnd = records.get(i + 1);
			String ticker = recordStart.getTicker();
			Double open = recordStart.getClose();
			Double close = recordEnd.getClose();
			Double changePersent = (close - open) / open;
			DecimalFormat df = new DecimalFormat("#0.00");
			String changePerc = null;
			if (close >= open) {
				changePerc = df.format(changePersent * 100) + "%";
			} else {
				changePerc = "-" + df.format((-changePersent) * 100) + "%";
			} 
			String change = new BigDecimal(String.valueOf(open)).subtract(new BigDecimal(String.valueOf(close))).toString();
			HashMap<String, Object> record = new HashMap<String, Object>();
			record.put("ticker", ticker);
			record.put("open", open);
			record.put("close", close);
			record.put("changepercent", changePerc);
			record.put("change", change);
			i = i + 2;
			recordDate.add(record);
		}
		return recordDate;
	}
	@Override
	public List<String> getTickersFromPortfolio(String username, String portfolioName) {
		// TODO Auto-generated method stub
		HibernateUtil.openSession();
		List<String> tickersFromPortfolio = portfolioDaoImpl.getTickersFromPortfolio(username, portfolioName);
		HibernateUtil.closeSession();
		return tickersFromPortfolio;
	}
	@Override
	public String deletePortfolioName(String username, String portfolioName) {
		// TODO Auto-generated method stub
		HibernateUtil.openSession();
		portfolioDaoImpl.deletePortfolioName(username, portfolioName);
		HibernateUtil.closeSession();
		return "success";
	}

	@Override
	public String deleteTickerFromPortfolio(String username, String portfolioName, String ticker) {
		// TODO Auto-generated method stub
		HibernateUtil.openSession();
		portfolioDaoImpl.deleteTickerFromPortfolio(username, portfolioName, ticker);
		HibernateUtil.closeSession();
		return "success";
	}

}

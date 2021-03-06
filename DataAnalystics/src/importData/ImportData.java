package importData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import citi.hibernate.dao.RecordDao;
import citi.hibernate.daoImpl.PortfolioDaoImpl;
import citi.hibernate.daoImpl.RecordDaoImpl;
import citi.hibernate.entity.Record;
import citi.hibernate.util.HibernateUtil;
import citi.service.RecordService;
import citi.serviceImpl.RecordServiceImpl;

public class ImportData {

	public  void traverseFolder2(String path) {

        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {
                for (File file2 : files) {
//                	for(int i = 0; i < 57; i++) {
                    if (file2.isDirectory()) {    
                        System.out.println("文件夹:" + file2.getAbsolutePath());
                        traverseFolder2(file2.getAbsolutePath());
                    } else {
                        System.out.println("文件:" + file2.getAbsolutePath());
                        System.out.println("i="+file2);
                        readData(file2.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }
	
	public  void readData(String path) {
		try { 
            BufferedReader reader = new BufferedReader(new FileReader(path));//换成你的文件名
            int start = path.lastIndexOf("_");
            int end = path.lastIndexOf(".");
            String ticker = path.substring(start+1, end);
            System.out.println("ticker="+ticker);
            //reader.readLine();//第一行信息，为标题信息，不用，如果需要，注释掉
            String line = null; 
            RecordService recordService = new RecordServiceImpl();
            while((line=reader.readLine())!=null){
                String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
                 recordService.insertRecord(new Record(ticker, item[0], item[1], Double.parseDouble(item[2]), Double.parseDouble(item[3]), Double.parseDouble(item[4]), Double.parseDouble(item[5]), Double.parseDouble(item[6])));
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		PortfolioDaoImpl p = new PortfolioDaoImpl();
//		HibernateUtil.openSession();
//		System.out.println("result="+p.getPortfolioName("admin"));
//		HibernateUtil.closeSession();
		ImportData importData = new ImportData();
		importData.traverseFolder2("C:\\Users\\Bruno\\Desktop\\Quant Quote Market Data - Jan to Mar 2016");
	}
	
	

}

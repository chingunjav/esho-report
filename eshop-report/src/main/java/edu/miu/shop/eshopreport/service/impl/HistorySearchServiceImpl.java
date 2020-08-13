package edu.miu.shop.eshopreport.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import edu.miu.shop.eshopreport.domain.DemoUser;
import edu.miu.shop.eshopreport.domain.SearchHistory;
import edu.miu.shop.eshopreport.repository.SearchHisRepository;
import edu.miu.shop.eshopreport.service.HistorySearchService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class HistorySearchServiceImpl  {
	@Autowired
	SearchHisRepository hisRepo;
	public List<SearchHistory> listHisReport(){
		return hisRepo.findAll();
	}

	public List<DemoUser> getUsers(){
		return getUserList();
	}
	
	
	private List<DemoUser> getUserList(){
	
		List<DemoUser> users  = new ArrayList<DemoUser>();
		users.add(new DemoUser(1,"TestUser",22,"Ub","test@mol.mn"));
		users.add(new DemoUser(2,"TestUser",23,"Ub","test@mol.mn"));
		users.add(new DemoUser(3,"TestUser",24,"Ub","test@mol.mn"));
		users.add(new DemoUser(4,"TestUser",24,"Ub","test@mol.mn"));
		users.add(new DemoUser(5,"TestUser",27,"Ub","test@mol.mn"));
		
		
		return users;
	}
	
	public String exportReport(String format) throws FileNotFoundException, JRException{
		List<SearchHistory> userList = this.listHisReport();
				
		String path = "D:\\JasperReport";
		String browserPath ="file://D:/JasperReport";
		File file = ResourceUtils.getFile("classpath:templates/searchHistory.jrxml");//ResourceUtils.getFile(resourceLocation: "classpath:usersjrxml");
		
		JasperReport jasper = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(userList);
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("createdBy","Chiba");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasper,parameters,ds);
		
		if(format.equalsIgnoreCase("html"))
		{
			JasperExportManager.exportReportToHtmlFile(jasperPrint,path + "\\searchHisReport.html");
			browserPath+="/usersReport.html";
		}
		if(format.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\searchHisReport.pdf");
			browserPath+="/usersReport.pdf";
		}
		
		
		//return "Success path: " + "<a href=\""+ browserPath + "\" target=\"_blank\" >view</a>";
		return "Success created:" + path;
	}
	
}

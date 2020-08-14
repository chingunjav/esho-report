package edu.miu.shop.eshopreport.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import edu.miu.shop.eshopreport.service.StorageService;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.HtmlExporterConfiguration;
import net.sf.jasperreports.export.HtmlExporterOutput;
import net.sf.jasperreports.export.HtmlReportConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;

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
		
		String createdURL = System.getProperty("user.dir")+"/src/main/resources/templates";
		
		File file = ResourceUtils.getFile("classpath:templates/searchHistory.jrxml");//ResourceUtils.getFile(resourceLocation: "classpath:usersjrxml");
		JasperReport jasper = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(userList);
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("createdBy","Chiba");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasper,parameters,ds);
		if(format.equalsIgnoreCase("html"))
		{
			JasperExportManager.exportReportToPdfFile(jasperPrint,createdURL + "/searchHisReport.pdf");
			
		}
		return "Success created:" + createdURL +"searchHisReport.xml";
	}



	
	
	
}

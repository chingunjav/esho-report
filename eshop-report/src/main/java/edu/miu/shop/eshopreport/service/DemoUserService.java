package edu.miu.shop.eshopreport.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import edu.miu.shop.eshopreport.domain.DemoUser;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class DemoUserService {

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
		List<DemoUser> userList = getUserList();

		
		String path = "D:\\JasperReport";
		String browserPath ="file://D:/JasperReport";
		File file = ResourceUtils.getFile("classpath:templates/users.jrxml");//ResourceUtils.getFile(resourceLocation: "classpath:usersjrxml");
		
		JasperReport jasper = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(userList);
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("createdBy","Chiba");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasper,parameters,ds);
		
		if(format.equalsIgnoreCase("html"))
		{
			JasperExportManager.exportReportToHtmlFile(jasperPrint,path + "\\usersReport.html");
			browserPath+="/usersReport.html";
		}
		if(format.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\usersReport.pdf");
			browserPath+="/usersReport.pdf";
		}
		
		
		//return "Success path: " + "<a href=\""+ browserPath + "\" target=\"_blank\" >view</a>";
		return "Success created:" + path;
	}
	
}

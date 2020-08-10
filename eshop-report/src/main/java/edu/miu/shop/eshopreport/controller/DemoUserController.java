package edu.miu.shop.eshopreport.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.shop.eshopreport.domain.DemoUser;
import edu.miu.shop.eshopreport.service.DemoUserService;
import net.sf.jasperreports.engine.JRException;


@RestController
@RequestMapping("/demo")
public class DemoUserController {
	@Autowired
	DemoUserService usrService;
	
	@GetMapping("/api/user")
	public List<DemoUser> getUsers(){
		return usrService.getUsers();
	}
	
	@GetMapping("/export/{format}")
	private String exportReport(@PathVariable String format) throws FileNotFoundException, JRException {
		return usrService.exportReport(format);
	}
}

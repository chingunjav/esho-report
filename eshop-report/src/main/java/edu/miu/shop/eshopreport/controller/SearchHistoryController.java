package edu.miu.shop.eshopreport.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.shop.eshopreport.domain.SearchHistory;
import edu.miu.shop.eshopreport.service.HistorySearchService;
import edu.miu.shop.eshopreport.service.impl.HistorySearchServiceImpl;
import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/reports")
public class SearchHistoryController {

	@Autowired
	HistorySearchServiceImpl hisService;
	
	@GetMapping("/export/html")
	private String exportReport() throws FileNotFoundException, JRException {
		return hisService.exportReport("html");
	}
	
	
}

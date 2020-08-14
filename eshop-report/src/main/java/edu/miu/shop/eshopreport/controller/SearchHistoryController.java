package edu.miu.shop.eshopreport.controller;

import java.awt.PageAttributes.MediaType;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLConnection;
import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.pdf.codec.Base64.InputStream;

import edu.miu.shop.eshopreport.domain.SearchHistory;
import edu.miu.shop.eshopreport.service.HistorySearchService;
import edu.miu.shop.eshopreport.service.impl.HistorySearchServiceImpl;
import net.sf.jasperreports.data.http.RequestMethod;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.repo.InputStreamResource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/reports")
public class SearchHistoryController {

	@Autowired
	HistorySearchServiceImpl hisService;
//	
//	@GetMapping("/export/html")
//	private String exportReport() throws FileNotFoundException, JRException {
//		return hisService.exportReport("html");
//	}
	
	
//	@GetMapping
//	    @Path("/download")
//	    @Produces(MediaType.APPLICATION_OCTET_STREAM)
//	    public Response downloadFileWithGet(@QueryParam("file") String file) {
//	        System.out.println("Download file "+file);
//	        File fileDownload = new File(Config.UPLOAD_FOLDER + File.separator + file);
//	        ResponseBuilder response = Response.ok((Object) fileDownload);
//	        response.header("Content-Disposition", "attachment;filename=" + file);
//	        return response.build();
//	    }

	 @RequestMapping("/pdf")
	public void downloadPDFResource(HttpServletRequest request, HttpServletResponse response) throws IOException, JRException {
		 
		hisService.exportReport("html");
		 
		File file = new File(System.getProperty("user.dir")+"/src/main/resources/templates/" + "searchHisReport.pdf");
		if (file.exists()) {
			//get the mimetype
			String mimeType = URLConnection.guessContentTypeFromName(file.getName());
			if (mimeType == null) {
				mimeType = "application/octet-stream";
			}
			response.setContentType(mimeType);
	
			response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

			 //Here we have mentioned it to show as attachment
			 //response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));

			response.setContentLength((int) file.length());

			BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));

			FileCopyUtils.copy(inputStream, response.getOutputStream());

		}
	}
}

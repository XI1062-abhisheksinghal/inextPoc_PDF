package com.home.inext.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.inext.service.PdfGeneratorService;

@RestController
public class PdfGenerator {
	
	@Autowired
	PdfGeneratorService pdfGeneratorService;
	
	
	@RequestMapping("/generatePdf")
	public void getPdf() {
		
		pdfGeneratorService.generatePdf();
		
	}

}

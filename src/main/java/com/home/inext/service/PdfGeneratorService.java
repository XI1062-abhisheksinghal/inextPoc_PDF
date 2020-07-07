package com.home.inext.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;


@Service
public class PdfGeneratorService  {
	
	
	public void generatePdf() {
		HeaderandFooter headerFooter = new HeaderandFooter();
		Document document = new Document();
		try {
			PdfWriter pdfWriter =PdfWriter.getInstance(document, new FileOutputStream("iTextHelloWorld.pdf"));
			Rectangle rectangle = new Rectangle(30, 30, 550, 800);
			
			Paragraph paragraph = new Paragraph();
			
			pdfWriter.setBoxSize("rectangle", rectangle);
			pdfWriter.setPageEvent(headerFooter);
			document.open();
			Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.CYAN);
			Chunk chunk = new Chunk("Hello World", font);
			paragraph.add(chunk);
			
			//Adding Image 
			//Part path = Paths.get(ClassLoader.getSystemResource("Java_logo.png").toURI());
			//Image img = Image.getInstance(path.toAbsolutePath().toString());
			//document.add(img);
			
			//Setting the header Footer in PDF using itext Library
			paragraph.setIndentationRight(50);
			paragraph.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph);
			//Adding new page to document 
			
			document.newPage();
	        document.add(new Paragraph("This is Page 2"));
			//document.add(new Paragraph("This is Header and Footer in Pdf Using Itext Example"));
			document.close();
			 
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		
	}
	

}

package com.home.inext.service;

import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font.FontFamily;



@Service
public class HeaderandFooter extends PdfPageEventHelper {
	
	 public void onStartPage(PdfWriter pdfWriter, Document document) {
	      System.out.println("onStartPage() method > Writing header in file");
	      Rectangle rect = pdfWriter.getBoxSize("rectangle");
	      
	      // TOP LEFT
	      ColumnText.showTextAligned(pdfWriter.getDirectContent(),
	               Element.ALIGN_CENTER, new Phrase("TOP LEFT"), rect.getLeft(),
	               rect.getTop(), 0);
	 
	      // TOP MEDIUM
	      ColumnText.showTextAligned(pdfWriter.getDirectContent(),
	               Element.ALIGN_CENTER, new Phrase("TOP MEDIUM"),
	               rect.getRight() / 2, rect.getTop(), 0);
	 
	      // TOP RIGHT
	      ColumnText.showTextAligned(pdfWriter.getDirectContent(),
	               Element.ALIGN_CENTER, new Phrase("TOP RIGHT"), rect.getRight(),
	               rect.getTop(), 0);
	  }
	 
	 public void onEndPage(PdfWriter pdfWriter, Document document) {
	      System.out.println("onEndPage() method > Writing footer in file");
	      Rectangle rect = pdfWriter.getBoxSize("rectangle");
	      // BOTTOM LEFT
	      ColumnText.showTextAligned(pdfWriter.getDirectContent(),
	               Element.ALIGN_CENTER, new Phrase("BOTTOM LEFT"),
	               rect.getLeft()+15, rect.getBottom(), 0);
	 
	      // BOTTOM MEDIUM
	      ColumnText.showTextAligned(pdfWriter.getDirectContent(),
	               Element.ALIGN_CENTER, new Phrase("BOTTOM MEDIUM"),
	               rect.getRight() / 2, rect.getBottom(), 0);
	 
	      // BOTTOM RIGHT
	      ColumnText.showTextAligned(pdfWriter.getDirectContent(),
	               Element.ALIGN_CENTER, new Phrase("BOTTOM RIGHT"),
	               rect.getRight()-10, rect.getBottom(), 0);
	      
	      
	      PdfContentByte pdfContentByte = pdfWriter.getDirectContentUnder();
	      
          String waterMarkText = "INVOICE";

	      Phrase phrase = new Phrase(waterMarkText, new Font(
                  FontFamily.HELVETICA, //Select the Font name of waterMark Text
                  60, //Select the Font type of waterMark Text
                  Font.ITALIC, //Select the Font style of waterMark Text 
                  BaseColor.LIGHT_GRAY)); //Select the Font colour of waterMark Text
                          //Keep colour as Light only, so that it appears
                          //Separately as watermark and  does not obscure text of the page
      

     // 300f is x axis,
     // 550f is y axis,
     ColumnText.showTextAligned(pdfContentByte,
                  Element.ALIGN_CENTER, //Keep waterMark center aligned
                  phrase, 300f, 500f,
                  45f); // 45f is the rotation angle
	      Rectangle pageSize = document.getPageSize();
	      System.out.println("page Size"+pageSize.BODY);
         // ColumnText.showTextAligned(pdfWriter.getDirectContent(), Element.ALIGN_CENTER, new Phrase("Title"), pageSize.getLeft(275), pageSize.getTop(30), 0);
          ColumnText.showTextAligned(pdfWriter.getDirectContent(), Element.ALIGN_RIGHT, new Phrase(String.format("No:%s", String.valueOf(pdfWriter.getCurrentPageNumber()))),
                  pageSize.getRight(30), pageSize.getTop(30), 0);
	  }
	

}

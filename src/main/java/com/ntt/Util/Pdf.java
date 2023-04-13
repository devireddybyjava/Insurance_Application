package com.ntt.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.ntt.Entity.CitizenPlan;
import com.ntt.repo.CitizenPlanRepository;


@Component
public class Pdf {
	
	@Autowired
	private CitizenPlanRepository planRepo;
	
	public void pdfGenertor(HttpServletResponse response, List<CitizenPlan> plans, File f ) throws Exception {
 	Document document = new Document(PageSize.A4);
	PdfWriter.getInstance(document, response.getOutputStream());
	PdfWriter.getInstance(document, new FileOutputStream("plans.pdf"));
	document.open();
	Paragraph p = new Paragraph("Citizen plan info");
	document.add(p);
	PdfPTable table = new PdfPTable(6);
	table.addCell("Id");
	table.addCell("Citizen Name");
	table.addCell("Plan Name");
	table.addCell("Plan Status");
	table.addCell("Start Date");
	table.addCell("End Date");
	
	for (CitizenPlan plan : plans) {
		table.addCell(String.valueOf(plan.getCitizenId()));
		table.addCell(plan.getCitizenName());
		table.addCell(plan.getCitizenPlanName());
		table.addCell(plan.getCitizenPlanStatus());
		table.addCell(plan.getCitizenPlanStartDate() + "");
		table.addCell(plan.getCitizenPlanEndDate() + "");
	}
	document.add(table);
	document.close();

}
}

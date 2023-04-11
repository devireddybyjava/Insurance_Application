package com.ntt.ServiceImpl;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.ntt.Dto.SearchRequest;
import com.ntt.Entity.CitizenPlan;
import com.ntt.Service.ReportService;
import com.ntt.repo.CitizenPlanRepository;


@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitizenPlanRepository planRepository;

	@Override
	public List<String> getPlanName() {

		return planRepository.getCitizenPlanName();
	}

	@Override
	public List<String> getPlanStatus() {

		return planRepository.getCitizenPlaNStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		// filter applying
		// using Dynamic Query using of Example.of()

		CitizenPlan entity = new CitizenPlan();
		
		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setCitizenPlanName(request.getPlanName());
		}
		if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setCitizenPlanStatus(request.getPlanStatus());
		}

		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setCitizenGeneder(request.getGender());
		}

		return planRepository.findAll(Example.of(entity));
		// Dates will not work because bugs there means diff formates
		// Remaining will works three plan names ,plan status and gender

	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
     Workbook workbook=new XSSFWorkbook();
     
     Sheet sheet=workbook.createSheet("plans-data");
     Row headerRow=sheet.createRow(0);
     
     headerRow.createCell(0).setCellValue("ID");
     headerRow.createCell(1).setCellValue("Citizen Name");
     headerRow.createCell(2).setCellValue("Plan Name");
     headerRow.createCell(3).setCellValue("Plan Status");
     headerRow.createCell(4).setCellValue("Plan Start Date");
     headerRow.createCell(5).setCellValue("Plan End Date");
     headerRow.createCell(6).setCellValue("Benefit Amount");
     
     List<CitizenPlan>records=planRepository.findAll();
     int dataRowIndex=1;
     for (CitizenPlan plan: records) {
    	 Row datarow=sheet.createRow(dataRowIndex);
    	 datarow.createCell(0).setCellValue(plan.getCitizenId());
    	 datarow.createCell(1).setCellValue(plan.getCitizenName());
    	 datarow.createCell(2).setCellValue(plan.getCitizenPlanName());
    	 datarow.createCell(3).setCellValue(plan.getCitizenPlanStatus());
    	 if(null!=plan.getCitizenPlanStartDate()) {
    	 
    	 datarow.createCell(4).setCellValue(plan.getCitizenPlanStartDate()+"");
    	 }else {
    		 datarow.createCell(4).setCellValue("N/A");
    	 }
    	 if(null!=plan.getCitizenPlanEndDate()) {
        	 
    	 datarow.createCell(5).setCellValue(plan.getCitizenPlanEndDate()+"");
    	 }
    	 else {
    		 datarow.createCell(5).setCellValue("N/A");
    	 }
        	 
        	 datarow.createCell(6).setCellValue(plan.getCitizenBenefitAmount());
    	dataRowIndex++;
 
    	 }
     ServletOutputStream outputStream=response.getOutputStream();
     workbook.write(outputStream);
     workbook.close();
     return true;
     
     }
	
	
     
     
     
	

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception  {
      Document document=new Document(PageSize.A4);
      PdfWriter.getInstance(document,response.getOutputStream());
      document.open();
      Paragraph p=new Paragraph("Citizen plan info");
      document.add(p);
      PdfPTable table=new PdfPTable(6);
      table.addCell("Id");
      table.addCell("Citizen Name");
      table.addCell("Plan Name");
      table.addCell("Plan Status");
      table.addCell("Start Date");
      table.addCell("End Date");

      List<CitizenPlan>records=planRepository.findAll();
      for(CitizenPlan plan:records) {
    	  table.addCell(String.valueOf(plan.getCitizenId()));
    	  table.addCell(plan.getCitizenName());
    	  table.addCell(plan.getCitizenPlanName());
    	  table.addCell(plan.getCitizenPlanStatus());
    	  table.addCell(plan.getCitizenPlanStartDate()+ "");
    	  table.addCell(plan.getCitizenPlanEndDate()+ "");
      }
             document.add(table);
             document.close();
		return true;
	}

}
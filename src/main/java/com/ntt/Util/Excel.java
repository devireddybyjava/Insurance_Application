package com.ntt.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ntt.Entity.CitizenPlan;
import com.ntt.repo.CitizenPlanRepository;
@Component
public class Excel {
	
	@Autowired
	private CitizenPlanRepository planRepo;
	
	public void excelGenerator(HttpServletResponse response, List<CitizenPlan> plans, File f) throws Exception{
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
	     
	     int dataRowIndex=1;
	     for (CitizenPlan plan: plans) {
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
	     
	     FileOutputStream fout=new FileOutputStream(new File("Plans.xls"));    
           workbook.write(fout);
         fout.close();   
	     
	     
	     
	     ServletOutputStream outputStream= response.getOutputStream();
	     workbook.write(outputStream);
	     workbook.close();
	}
    
}

package com.ntt.ServiceImpl;

import java.io.File;
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
import com.ntt.Util.EmailUtil;
import com.ntt.Util.Excel;
import com.ntt.repo.CitizenPlanRepository;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitizenPlanRepository planRepository;

	@Autowired
	private Excel excel;

	@Autowired
	private EmailUtil emailUtils;

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

		File f = new File("Plans.xls");
		List<CitizenPlan> plans = planRepository.findAll();
		excel.excelGenerator(response, plans, f);
		String sub = "System Generated Mail";
		String body = "<h5>Good Afternoon, Prathyusha<h5>," + " <h5>Hope you are well...!</h5>,"+"<p>This mail is system generated mail,you won't be reply to this mail,Please ignore this mail ...{::)</p>";
		String to = "prathyushasanga2408@gmail.com";
		emailUtils.sendEmail(sub, body, to, f);
		f.delete();
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
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

		List<CitizenPlan> records = planRepository.findAll();
		for (CitizenPlan plan : records) {
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getCitizenPlanName());
			table.addCell(plan.getCitizenPlanStatus());
			table.addCell(plan.getCitizenPlanStartDate() + "");
			table.addCell(plan.getCitizenPlanEndDate() + "");
		}
		document.add(table);
		document.close();
		return true;
	}

}
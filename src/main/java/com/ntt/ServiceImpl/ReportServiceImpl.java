package com.ntt.ServiceImpl;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import com.ntt.Util.Pdf;
import com.ntt.repo.CitizenPlanRepository;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitizenPlanRepository planRepository;

	@Autowired
	private Excel excel;
	
	@Autowired
	private Pdf pf;

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
		String body = "<h5>Good Afternoon,Param<h5>,<h5>Hope you are well...!</h5>,<h6>This mail is system generated mail,you won't be reply to this mail,Please ignore this mail ...{::)</h6>";
		String to = "vennelareddy747@gmail.com";
		emailUtils.sendEmail(sub, body, to, f);
		f.delete();
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		File f = new File("plans.pdf");
		List<CitizenPlan> plans = planRepository.findAll();
		pf.pdfGenertor(response, plans, f);
		String sub = "System Generated Mail";
		String body = "<h6>This mail is system generated mail,you won't be reply to this mail,Please ignore this mail ...{::)</h6>";
		String to = "vennelareddy747@gmail.com";
		emailUtils.sendEmail(sub, body, to, f);
		f.delete();
		return true;
	}

}
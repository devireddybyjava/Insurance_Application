package com.ntt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ntt.Dto.SearchRequest;
import com.ntt.Entity.CitizenPlan;
import com.ntt.Service.ReportService;


@Controller
public class ReportController {

	@Autowired
	private ReportService reportService;

	@GetMapping("/")
	public String indexPage(Model model) {
		// iif you want bing sReauest to ui used Model
		// SearchRequest searchObj = new SearchRequest();
		// model.addAttribute("search", searchObj);
		// (Or)
		init(model);
		return "index";
	}

	private void init(Model model) {
		model.addAttribute("search", new SearchRequest());
		model.addAttribute("planName", reportService.getPlanName());
		model.addAttribute("planStatus", reportService.getPlanStatus());
	}

	@PostMapping("/search")
	public String handleSearchRequest(SearchRequest request, Model model) {
		System.out.println(request);
		List<CitizenPlan> listPlans = reportService.search(request);
		model.addAttribute("plans", listPlans);
		init(model);
		return "index";

	}
}
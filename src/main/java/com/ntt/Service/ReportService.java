package com.ntt.Service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.ntt.Dto.SearchRequest;
import com.ntt.Entity.CitizenPlan;



public interface ReportService {

	public List<String> getPlanName();

	public List<String> getPlanStatus();

	public List<CitizenPlan> search(SearchRequest request);

	public boolean exportExcel(HttpServletResponse response) throws Exception;

	public boolean exportPdf (HttpServletResponse response) throws Exception;

}
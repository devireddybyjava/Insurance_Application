package com.ntt.Service;

import java.util.List;

import com.ntt.Dto.SearchRequest;
import com.ntt.Entity.CitizenPlan;



public interface ReportService {

	public List<String> getPlanName();

	public List<String> getPlanStatus();

	public List<CitizenPlan> search(SearchRequest request);

	public boolean exportExcel();

	public boolean exportPdf();

}

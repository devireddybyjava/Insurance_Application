package com.ntt.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ntt.Entity.CitizenPlan;
import com.ntt.repo.CitizenPlanRepository;


@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private CitizenPlanRepository repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// Cash Plan Data

		repo.deleteAll();
		
		CitizenPlan c1 = new CitizenPlan();
		c1.setCitizenName("Ram");
		c1.setCitizenGeneder("Male");
		c1.setCitizenPlanName("Cash");
		c1.setCitizenPlanStatus("Approved");
		c1.setCitizenPlanStartDate(LocalDate.now());
		c1.setCitizenPlanEndDate(LocalDate.now().plusMonths(8));
		c1.setCitizenBenefitAmount(5000.00);

		// Cash Data Plan
		CitizenPlan c2 = new CitizenPlan();
		c2.setCitizenName("Ramya");
		c1.setCitizenGeneder("Fe-Male");
		c2.setCitizenPlanName("Cash");
		c2.setCitizenPlanStatus("Denoied");
		c2.setCitizenDenialReason("Rental Income");

		// Cash Data Plan
		CitizenPlan c3 = new CitizenPlan();
		c3.setCitizenName("Ramu");
		c3.setCitizenGeneder("Male");
		c3.setCitizenPlanName("Cash");
		c3.setCitizenPlanStatus("Terminated");
		c3.setCitizenPlanStartDate(LocalDate.now().minusMonths(4));
		c3.setCitizenPlanEndDate(LocalDate.now().plusMonths(8));
		c3.setCitizenBenefitAmount(5000.00);
		c3.setCitizenTerminatedDate(LocalDate.now());
		c3.setCitizenTerminationReson("Employee");

		// Food Plan Data

		CitizenPlan c4 = new CitizenPlan();
		c4.setCitizenName("Raj");
		c4.setCitizenGeneder("Male");
		c4.setCitizenPlanName("Food");
		c4.setCitizenPlanStatus("Approved");
		c4.setCitizenPlanStartDate(LocalDate.now());
		c4.setCitizenPlanEndDate(LocalDate.now().plusMonths(8));
		c4.setCitizenBenefitAmount(4000.00);

		// Food Data Plan
		CitizenPlan c5 = new CitizenPlan();
		c5.setCitizenName("Ramyakumari");
		c5.setCitizenGeneder("Fe-Male");
		c5.setCitizenPlanName("Food");
		c5.setCitizenPlanStatus("Denoied");
		c5.setCitizenDenialReason("Property Income");

		// Food Data Plan
		CitizenPlan c6 = new CitizenPlan();
		c6.setCitizenName("Raj kumar");
		c6.setCitizenGeneder("Male");
		c6.setCitizenPlanName("Food");
		c6.setCitizenPlanStatus("Terminated");
		c6.setCitizenPlanStartDate(LocalDate.now().minusMonths(4));
		c6.setCitizenPlanEndDate(LocalDate.now().plusMonths(8));
		c6.setCitizenBenefitAmount(5000.00);
		c6.setCitizenTerminatedDate(LocalDate.now());
		c6.setCitizenTerminationReson("Employee");

		// Medical Plan Data

		CitizenPlan c7 = new CitizenPlan();
		c7.setCitizenName("Raju");
		c7.setCitizenGeneder("Male");
		c7.setCitizenPlanName("Medical");
		c7.setCitizenPlanStatus("Approved");
		c7.setCitizenPlanStartDate(LocalDate.now());
		c7.setCitizenPlanEndDate(LocalDate.now().plusMonths(8));
		c7.setCitizenBenefitAmount(4000.00);

		// Food Data Plan
		CitizenPlan c8 = new CitizenPlan();
		c8.setCitizenName("Ramyasri");
		c8.setCitizenGeneder("Fe-Male");
		c8.setCitizenPlanName("Medical");
		c8.setCitizenPlanStatus("Denoied");
		c8.setCitizenDenialReason("Property Income");

		// Food Data Plan
		CitizenPlan c9 = new CitizenPlan();
		c9.setCitizenName("Rajakumari");
		c9.setCitizenGeneder("Fe-Male");
		c9.setCitizenPlanName("Medical");
		c9.setCitizenPlanStatus("Terminated");
		c9.setCitizenPlanStartDate(LocalDate.now().minusMonths(4));
		c9.setCitizenPlanEndDate(LocalDate.now().plusMonths(8));
		c9.setCitizenBenefitAmount(5000.00);
		c9.setCitizenTerminatedDate(LocalDate.now());
		c9.setCitizenTerminationReson("Government Employee");

		// EmployeeMent Plan Data

		CitizenPlan c10 = new CitizenPlan();
		c10.setCitizenName("Siva");
		c10.setCitizenGeneder("Male");
		c10.setCitizenPlanName("EmployeeMent");
		c10.setCitizenPlanStatus("Approved");
		c10.setCitizenPlanStartDate(LocalDate.now());
		c10.setCitizenPlanEndDate(LocalDate.now().plusMonths(8));
		c10.setCitizenBenefitAmount(4000.00);

		// Food Data Plan
		CitizenPlan c11 = new CitizenPlan();
		c11.setCitizenName("Sivamma");
		c11.setCitizenGeneder("Fe-Male");
		c11.setCitizenPlanName("EmployeeMent");
		c11.setCitizenPlanStatus("Denoied");
		c11.setCitizenDenialReason("Property Income");

		// Food Data Plan
		CitizenPlan c12 = new CitizenPlan();
		c12.setCitizenName("SivaLakshmi");
		c12.setCitizenGeneder("Fe-Male");
		c12.setCitizenPlanName("EmployeeMent");
		c12.setCitizenPlanStatus("Terminated");
		c12.setCitizenPlanStartDate(LocalDate.now().minusMonths(4));
		c12.setCitizenPlanEndDate(LocalDate.now().plusMonths(8));
		c12.setCitizenBenefitAmount(5000.00);
		c12.setCitizenTerminatedDate(LocalDate.now());
		c12.setCitizenTerminationReson("Government Employee");

		List<CitizenPlan> list = Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12);

		repo.saveAll(list);

	}

}
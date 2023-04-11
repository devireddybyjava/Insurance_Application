package com.ntt.Entity;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CITIZEN_PLANS_INFO")
public class CitizenPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long citizenId;
	private String citizenName;
	private String citizenGeneder;
	private String citizenPlanName;
	private String citizenPlanStatus;
	private LocalDate citizenPlanStartDate;
	private LocalDate citizenPlanEndDate;
	private double citizenBenefitAmount;
	private String citizenDenialReason;
	private LocalDate citizenTerminatedDate;
	private String citizenTerminationReson;
	public Long getCitizenId() {
		return citizenId;
	}
	public void setCitizenId(Long citizenId) {
		this.citizenId = citizenId;
	}
	public String getCitizenName() {
		return citizenName;
	}
	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}
	public String getCitizenGeneder() {
		return citizenGeneder;
	}
	public void setCitizenGeneder(String citizenGeneder) {
		this.citizenGeneder = citizenGeneder;
	}
	public String getCitizenPlanName() {
		return citizenPlanName;
	}
	public void setCitizenPlanName(String citizenPlanName) {
		this.citizenPlanName = citizenPlanName;
	}
	public String getCitizenPlanStatus() {
		return citizenPlanStatus;
	}
	public void setCitizenPlanStatus(String citizenPlanStatus) {
		this.citizenPlanStatus = citizenPlanStatus;
	}
	public LocalDate getCitizenPlanStartDate() {
		return citizenPlanStartDate;
	}
	public void setCitizenPlanStartDate(LocalDate citizenPlanStartDate) {
		this.citizenPlanStartDate = citizenPlanStartDate;
	}
	public LocalDate getCitizenPlanEndDate() {
		return citizenPlanEndDate;
	}
	public void setCitizenPlanEndDate(LocalDate citizenPlanEndDate) {
		this.citizenPlanEndDate = citizenPlanEndDate;
	}
	public double getCitizenBenefitAmount() {
		return citizenBenefitAmount;
	}
	public void setCitizenBenefitAmount(double citizenBenefitAmount) {
		this.citizenBenefitAmount = citizenBenefitAmount;
	}
	public String getCitizenDenialReason() {
		return citizenDenialReason;
	}
	public void setCitizenDenialReason(String citizenDenialReason) {
		this.citizenDenialReason = citizenDenialReason;
	}
	public LocalDate getCitizenTerminatedDate() {
		return citizenTerminatedDate;
	}
	public void setCitizenTerminatedDate(LocalDate citizenTerminatedDate) {
		this.citizenTerminatedDate = citizenTerminatedDate;
	}
	public String getCitizenTerminationReson() {
		return citizenTerminationReson;
	}
	public void setCitizenTerminationReson(String citizenTerminationReson) {
		this.citizenTerminationReson = citizenTerminationReson;
	}
	@Override
	public String toString() {
		return "CitizenPlan [citizenId=" + citizenId + ", citizenName=" + citizenName + ", citizenGeneder="
				+ citizenGeneder + ", citizenPlanName=" + citizenPlanName + ", citizenPlanStatus=" + citizenPlanStatus
				+ ", citizenPlanStartDate=" + citizenPlanStartDate + ", citizenPlanEndDate=" + citizenPlanEndDate
				+ ", citizenBenefitAmount=" + citizenBenefitAmount + ", citizenDenialReason=" + citizenDenialReason
				+ ", citizenTerminatedDate=" + citizenTerminatedDate + ", citizenTerminationReson="
				+ citizenTerminationReson + "]";
	}

}

package com.employee.management.bean;

import java.util.List;

import org.springframework.stereotype.Component;

@Component

public class Employee {
	private int empNo;
	private String empName;
	private int empAge;
	private double empSal;
	private List<String> empOrg;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public List<String> getEmpOrg() {
		return empOrg;
	}
	public void setEmpOrg(List<String> empOrg) {
		this.empOrg = empOrg;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}
	
	
	

}

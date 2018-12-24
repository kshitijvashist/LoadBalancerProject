package com.employee.management.controller;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.bean.Employee;
import com.employee.management.mongodb.MongoDBUtility;

@RestController
public class EmployeeController {
	@Autowired
	private Employee employee;
	
	@RequestMapping("/")
	public String  healthCheck()
	{
		return "abc";
	}
	
	
	
	@RequestMapping("/employee/get")
	public List<Document> getEmployeeDetails() {
		MongoDBUtility mongoGet=new MongoDBUtility();
		List<Document> getAllDoc =mongoGet.getEmployeeData();
		return getAllDoc;
	}
	
	
	@RequestMapping(value="/employee/create", method=RequestMethod.PUT, consumes = "application/json")
	public List<Document> createEmployee(@RequestBody Employee emp) {
		MongoDBUtility mongoGet=new MongoDBUtility();
		
		List<Document> getAllDoc=mongoGet.createEmployeeData(emp);
		System.out.println(emp.getEmpName());
		System.out.println(emp.getEmpOrg());
		
		employee.setEmpName(emp.getEmpName());
		employee.setEmpOrg(emp.getEmpOrg());
	return getAllDoc;
}
	
	@RequestMapping(value="/employee/edit", method=RequestMethod.POST, consumes = "application/json")
	public List<Document> editEmployee(@RequestBody Employee emp) {
		MongoDBUtility mongoGet=new MongoDBUtility();
		
		List<Document> getAllDoc=mongoGet.editEmployeeData(emp);
		System.out.println(emp.getEmpName());
		System.out.println(emp.getEmpAge());
		
		employee.setEmpName(emp.getEmpName());
		employee.setEmpOrg(emp.getEmpOrg());
	return getAllDoc;
}
	
	@RequestMapping(value="/employee/delete", method=RequestMethod.DELETE, consumes = "application/json")
	public List<Document> deleteEmployee(@RequestBody Employee emp) {
		MongoDBUtility mongoGet=new MongoDBUtility();
		
		System.out.println(emp.getEmpNo());
		List<Document> getAllDoc=mongoGet.deleteEmployeeData(emp);
		
		
	return getAllDoc;
}
	
	

}

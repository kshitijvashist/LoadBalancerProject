package com.employee.management.controller;

import java.util.List;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.bean.Employee;
import com.employee.management.mongodb.MongoDBUtility;


//@Configuration
//@EnableWebSecurity
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeController {

	private static final Logger logger =LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private Employee employee;

	@RequestMapping("/")
	public String  healthCheck()
	{
		logger.info("Controller has been called successfully");
		return "Application is working Successfully.";
	}



	@RequestMapping("/employee/get")
	public List<Document> getEmployeeDetails() {
		MongoDBUtility mongoGet=new MongoDBUtility();
		List<Document> getAllDoc =mongoGet.getEmployeeData();

		logger.info("Get Employee Details:-"+getAllDoc);
		return getAllDoc;
	}


	@RequestMapping(value="/employee/create", method=RequestMethod.PUT, consumes = "application/json")
	public List<Document> createEmployee(@RequestBody Employee emp) {
		MongoDBUtility mongoGet=new MongoDBUtility();

		List<Document> getAllDoc=mongoGet.createEmployeeData(emp);

		logger.info("Create Employee Request Using Put Method");
		logger.info("Employee Name:-"+emp.getEmpName());


		employee.setEmpName(emp.getEmpName());
		employee.setEmpOrg(emp.getEmpOrg());
		return getAllDoc;
	}

	@RequestMapping(value="/employee/createEmployee", method=RequestMethod.POST, consumes = "application/json")
	public List<Document> createEmployeeForAxios(@RequestBody Employee emp) {
		MongoDBUtility mongoGet=new MongoDBUtility();

		List<Document> getAllDoc=mongoGet.createEmployeeData(emp);
		logger.info("Create Employee Request Using Post Method");
		logger.info("Employee Name:-"+emp.getEmpName());

		employee.setEmpName(emp.getEmpName());
		employee.setEmpOrg(emp.getEmpOrg());
		return getAllDoc;
	}

	@RequestMapping(value="/employee/edit", method=RequestMethod.POST, consumes = "application/json")
	public List<Document> editEmployee(@RequestBody Employee emp) {
		MongoDBUtility mongoGet=new MongoDBUtility();

		List<Document> getAllDoc=mongoGet.editEmployeeData(emp);
		logger.info("Edit Employee Request Using Post Method");
		logger.info("Employee Name:-"+emp.getEmpName());
		logger.info("Employee Age:-"+emp.getEmpAge());


		employee.setEmpName(emp.getEmpName());
		employee.setEmpOrg(emp.getEmpOrg());
		return getAllDoc;
	}
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value="/employee/delete", method=RequestMethod.DELETE, consumes = "application/json")
	public List<Document> deleteEmployee(@RequestBody Employee emp) {
		MongoDBUtility mongoGet=new MongoDBUtility();

		logger.info("Delete Employee Request Using Delete Method");
		logger.info("Employee No:-"+emp.getEmpNo());

		List<Document> getAllDoc=mongoGet.deleteEmployeeData(emp);


		return getAllDoc;
	}


	@RequestMapping(value="/employee/delete/{empNo}", method=RequestMethod.DELETE)
	public List<Document> deleteEmployeeForAxios(@PathVariable("empNo") int empNo) {
		MongoDBUtility mongoGet=new MongoDBUtility();

		System.out.println("Axios for delete Request");
		List<Document> getAllDoc=mongoGet.deleteEmployeeDataForAxios(empNo);


		return getAllDoc;
	}



}

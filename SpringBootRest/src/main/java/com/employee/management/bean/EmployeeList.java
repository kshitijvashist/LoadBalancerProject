package com.employee.management.bean;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
public class EmployeeList {
	private List<Document> doc;
	
	public EmployeeList()
	{
		doc=new ArrayList<>();
	}

	public List<Document> getDoc() {
		return doc;
	}

	public void setDoc(List<Document> doc) {
		this.doc = doc;
	}

	
	

}

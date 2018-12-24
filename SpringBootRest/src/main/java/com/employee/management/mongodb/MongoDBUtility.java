package com.employee.management.mongodb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.employee.management.bean.Employee;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates; 

public class MongoDBUtility {
	List<Document> iterDoc;
	MongoClient mongoClient;
	 MongoCollection<Document> collection;
	 MongoDatabase database;
	
	public MongoDBUtility()
	{
		 iterDoc=null;
		 mongoClient = new MongoClient( "localhost" , 27017 );
		 MongoCredential credential; 
		    credential = MongoCredential.createPlainCredential("sampleUser", "Emp_DB", 
		       "password".toCharArray()); 
		    System.out.println("Connected to the database successfully");  
		   // System.out.println("Credentials ::"+ credential);
		    
		     database = mongoClient.getDatabase("Emp_DB"); 
		    collection = database.getCollection("Employee");
	}
	//MongoClient mongoClient = new MongoClient(); //connects to default host and port i.e 127.0.0.1:27017
	
	public List<Document> createEmployeeData(Employee employee)
	{
		   Document document=new Document("empNo",employee.getEmpNo())
	  		.append("empName", employee.getEmpName()).append("empAge",employee.getEmpAge()).append("empSal",employee.getEmpSal());
		 
		   collection.insertOne(document);
		   
		   iterDoc = collection.find().into(
					new ArrayList<Document>()); 
		   
		   return iterDoc;
		   
		   
	}
	
	public List<Document> editEmployeeData(Employee employee)
	{
		System.out.println(employee.getEmpAge()+employee.getEmpName()+employee.getEmpSal());
		collection.updateOne(Filters.eq("empNo",employee.getEmpNo()), Updates.set("empAge", employee.getEmpAge()));
		collection.updateOne(Filters.eq("empNo",employee.getEmpNo()), Updates.set("empName", employee.getEmpName()));
		collection.updateOne(Filters.eq("empNo",employee.getEmpNo()), Updates.set("empSal", employee.getEmpSal()));
				
		   
		   iterDoc = collection.find().into(
					new ArrayList<Document>()); 
		   System.out.println(iterDoc);
		   
		   return iterDoc;
		   
		   
	}
	
	public List<Document> deleteEmployeeData(Employee employee)
	{
		try
		{
			System.out.println(collection);
		collection.deleteOne(Filters.eq("empNo", employee.getEmpNo()));
		   iterDoc = collection.find().into(
					new ArrayList<Document>()); 
		   System.out.println(iterDoc);
		}
		   
		   catch(Exception e){
			   e.printStackTrace();
		   }
			 
		   
		   return iterDoc;
		   
		   
	}
	public  List<Document>  getEmployeeData()
	{
		
		
		try
		{
 // should use this always
	
	 
    //System.out.println("Collection myCollection selected successfully"+collection.count());
    
    
    
//
   
  
    // Getting the iterable object 
     iterDoc = collection.find().into(
			new ArrayList<Document>()); 
   // int i = 1; 

    // Getting the iterator 
//    Iterator it = iterDoc.iterator(); 
////  
//   while (it.hasNext()) {  
//      System.out.println(it.next());  
//   i++; 
   //}
//    
//    System.out.println("document inserted successfully");
// 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			mongoClient.close();
		}
		
		return iterDoc;
	
	}

	
}

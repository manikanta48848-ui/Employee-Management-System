package com.Project.Modules;

import java.util.ArrayList;
import java.util.*;

public class EmployeeService {
	
	ArrayList<Employee> employees=new ArrayList();
	
	
	//Duplicate Id Avoidence HELPER Method
	public boolean isIdExists(int id) {

	    for(Employee e : employees) {

	        if(e.getId() == id) {
	            return true;
	        }
	    }

	    return false;
	}
	//DEPENDENT METHOD
	public int getUniqueId(Scanner sc) {

	    while (true) {

	        int id = InputValidator.getInt(sc, "Enter Employee ID: ");

	        if (isIdExists(id)) {

	            System.out.println("Employee ID already exists. Please enter another ID.");

	        } else {

	            return id;
	        }
	    }
	}
	
	public void addEmployee(Employee emp) {
	    employees.add(emp);
	}
	
	
	public void displayEmployees()
	{
		if(employees.isEmpty())
		{
			System.out.println("No Empoloyees Found");
			return;
		}
		for(Employee e:employees)
		{
			System.out.println(e);
		}
	}
	
	public void searchEmployee(int id)
	{
	for(Employee e:employees) {
		if(e.getId()==id)
		{
			System.out.println("Employee Found..");
			System.out.println(e);
           return;			
		}
			
	 }
	System.out.println("Employee Not Found With This id: "+id);
	
    }
	
	public void deleteEmployee(int id)
	{

	    Iterator<Employee> iterator = employees.iterator();


	    while(iterator.hasNext()) {

	        Employee e = iterator.next();


	        if(e.getId() == id) {

	            iterator.remove();

	            System.out.println("Employee Deleted Successfully");

	            return;
	        }
	    }


	    System.out.println("Employee Not Found With ID: " + id);
	}
	/* 
	public void deleteEmployee(int id) {

    boolean removed = employees.removeIf(e -> e.getId() == id);

    if(removed) {
        System.out.println("Employee Deleted Successfully");
    }
    else {
        System.out.println("Employee Not Found");
    }
}*/
	//Method Overloading
	public void deleteEmployee(String name) {

	    Iterator<Employee> iterator = employees.iterator();

	    while(iterator.hasNext()) {

	        Employee e = iterator.next();

	        if(e.getName().equalsIgnoreCase(name)) {

	            iterator.remove();

	            System.out.println("Employee Deleted Successfully");
	            return;
	        }
	    }

	    System.out.println("Employee Not Found With Name: " + name);
	}
	
	public void updateSalary(int id,double newSal)
	{
		for(Employee e:employees)
		{
		 if(e.getId()==id)
		 {
		   e.setSalary(newSal);
		   System.out.println("Salary Updated..");
		 }
		}
		
	}
	//Methods For Sorting Employees//
	//By Id
	public void sortById(boolean ascending) {

	    if(ascending) {

	        employees.sort(Comparator.comparingInt(Employee::getId));

	    }
	    else {

	        employees.sort(Comparator.comparingInt(Employee::getId).reversed());

	    }

	    displayEmployees();
	}
	
	//By name
	public void sortByName() {

	    employees.sort(
	        Comparator.comparing(Employee::getName)
	    );

	    System.out.println("Employees Sorted By Name");

	    displayEmployees();
	}
	
	//By Salary
	public void sortBySalary(boolean ascending) {

	    if(ascending) {

	        employees.sort(
	            Comparator.comparingDouble(Employee::getSalary)
	        );

	    }
	    else {

	        employees.sort(
	            Comparator.comparingDouble(Employee::getSalary).reversed()
	        );

	    }

	    System.out.println("Employees Sorted By Salary");

	    displayEmployees();
	}
	
	//Method To print HighestSalary
	
	public void highSalary()
	{
		employees.stream().max(Comparator.comparingDouble(Employee::getSalary)).
		ifPresent(hs->System.out.println("Higest Paid Employee is: "+hs.getName()+" Earns: "+hs.getSalary()));
	}
	
	//Method To Display Department-wise Employees
	
	public void displayEmployeesByDepartment(String department) {
	    boolean found = false;
	    for(Employee e : employees) {
	        if(e.getDepartment().equalsIgnoreCase(department)) {
	            System.out.println(e);
	            found = true;
	        }
	    }
	    if(!found) {
	        System.out.println("No Employees Found In Department: " + department);
	    }
	}
}

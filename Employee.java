package com.Project.Modules;

public class Employee {
	private int id;
	private String name;
	private double salary;
	private String department;
   
	public Employee(int id, String name, double salary, String department) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}	
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public String getDepartment() {
		return department;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	@Override
	public String toString() {
		return "Id:"+ id +"|"+" Name:" + name +"|"+ " Department:" + department +"|"+ " Salary:" + salary+"|";
	}
	
	
}

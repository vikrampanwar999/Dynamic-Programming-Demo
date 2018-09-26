package com;

public class Employee implements Comparable<Employee>{
	
	int id;
	String name;
	String Department;
	String OfficeLocation;
	long salary;
	int experience;
	
	public Employee(int id, String name, String department, String officeLocation, long salary, int experience) {
		super();
		this.id = id;
		this.name = name;
		Department = department;
		OfficeLocation = officeLocation;
		this.salary = salary;
		this.experience = experience;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getOfficeLocation() {
		return OfficeLocation;
	}

	public void setOfficeLocation(String officeLocation) {
		OfficeLocation = officeLocation;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return this.getId()-o.getId();
	}

}

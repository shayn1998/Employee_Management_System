package com.wipro.bean;

public class EmployeeBean {
	private int empID;
	private String Name;
	private float salary;
	private String designation;
	
	public EmployeeBean(int empID, String Name, float salary, String designation) {
		this.empID = empID;
		this.Name = Name;
		this.salary = salary;
		this.designation = designation;
	}
	
	public void set_empID(int empID) {
		this.empID = empID;
	}
	
	public int get_empID() {
		return empID;
	}
	
	public void set_Name(String Name){
		this.Name = Name;
	}
	
	public String get_Name() {
		return Name;
	}
	
	public void set_salary(float salary) {
		this.salary = salary;
	}
	
	public float get_salary(){
		return salary;
	}
	
	public void set_designation(String designation) {
		this.designation = designation;
	}
	
	public String get_designation() {
		return designation;
	}
	
	
	

}

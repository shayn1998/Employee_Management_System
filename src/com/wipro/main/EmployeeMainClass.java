package com.wipro.main;
import java.util.*;
import com.wipro.bean.EmployeeBean;
import com.wipro.service.EmployeeService;

public class EmployeeMainClass {
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		EmployeeService es = new EmployeeService();
		int option;
		do{
			System.out.println("Enter the option..");
			option = sc.nextInt();
			switch(option){
			case 1:
				System.out.println("Enter the employee id");
				int i1 = sc.nextInt();
				System.out.println("Enter the employee name");
				String name_of_employee1 = sc.next();
				System.out.println("Enter the employee salary");
				float f1 = sc.nextFloat();
				System.out.println("Enter the designation");
				String designation_of_Employee1 = sc.next();
				EmployeeBean bean1 = new EmployeeBean(i1,name_of_employee1,f1,designation_of_Employee1);
				
				if(es.insertEmployee(bean1)) {
					System.out.println("Employee added Successfully");
				}
		
				else {
					System.out.println("Can't add Employee");
				}
				break;
				
			case 2:
				System.out.println("Enter the employee id");
				int i2 = sc.nextInt();
				System.out.println("Enter the employee name");
				String name_of_employee2 = sc.next();
				System.out.println("Enter the employee salary");
				float f2 = sc.nextFloat();
				System.out.println("Enter the designation");
				String designation_of_Employee2 = sc.next(); 
				System.out.println("Enter the position where you want to enter the employee object");
				int position = sc.nextInt();
				EmployeeBean bean2 = new EmployeeBean(i2,name_of_employee2,f2,designation_of_Employee2);
				String s = es.insertEmployeeByPosition(bean2, position);
				System.out.println(s);
				break;
				
			case 3:
				List<EmployeeBean> eb_main = es.fetchAllEmployees();
				Iterator i = eb_main.iterator();
				while(i.hasNext()) {
					EmployeeBean employee = (EmployeeBean) i.next();
					System.out.println(employee.get_Name());
					System.out.println(employee.get_empID());
					System.out.println(employee.get_salary());
					System.out.println(employee.get_designation());
					
				}
				
				break;
				
			case 4:
				System.out.println("Enter the employee id");
				int i3 = sc.nextInt();
				if(es.deleteEmployeeByEmpID(i3)) {
					System.out.println("Employee deleted successfully");
				}
				else {
					System.out.println("Can't delete Employee");
				}
				break;
				
			case 5:
				System.out.println("Enter the employee id");
				int i4 = sc.nextInt();
				System.out.println("Enter the employee name");
				String name_of_employee3 = sc.next();
				System.out.println("Enter the employee salary");
				float f3 = sc.nextFloat();
				System.out.println("Enter the designation");
				String designation_of_employee3 = sc.next();
				System.out.println("Enter the new salary");
				float f4 = sc.nextFloat();
				
				EmployeeBean bean3 = new EmployeeBean(i4,name_of_employee3,f3,designation_of_employee3);
				es.updateEmployeeByEmpId(bean3, f4);
				break;
				
			case 6:
				System.out.println("Enter the id of the employee");
				int i5 = sc.nextInt();
				EmployeeBean eb4 = es.findEmployeeByEmpID(i5);
				if(eb4 != null) {
					System.out.println("Employee "+eb4.get_Name()+" empid "+eb4.get_empID()+" salary "+eb4.get_salary());
				}
				else {System.out.println("Employee not found");}
				break;
				
			case 0:
				System.out.println("Exiting..");
				break;
				
			default:
				System.out.println("Invalid option");
				break;
	}
		}
		while(option != 0);
}
}
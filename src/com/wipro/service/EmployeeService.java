package com.wipro.service;
import java.util.*;
import com.wipro.bean.EmployeeBean;
public class EmployeeService {
	
	private static List<EmployeeBean> listEmp = new ArrayList<>();
	private static List<Integer> li = new ArrayList<>();
	public boolean insertEmployee(EmployeeBean bean){
		boolean b = false;
		if(!(li.contains(bean.get_empID()))) {
			listEmp.add(bean);
			li.add(bean.get_empID());
			b = true;
		}
		
		else {
			b = false;	
		}
		
		return b;
	}
	
	public String insertEmployeeByPosition(EmployeeBean bean, int position) {
		String s = "Can't add as employee already exists  ";
		if(!(li.contains(bean.get_empID()))) {
			if(position < listEmp.size()){
				listEmp.add(position, bean);
				s = "Inserted Employee at Position :"+position;
			}
		
			else {
				listEmp.add(bean);
				s = "Inserted Employee at end position :"+listEmp.size();
				}
		}
		
		return s;
	
	}
	
	public List<EmployeeBean> fetchAllEmployees(){
		List<EmployeeBean> l1 = new ArrayList<>();
		if(listEmp.size() > 0) {
			l1 = listEmp;
		}
		else {
			l1 = null;
		}
		return l1;
	}
	
	public boolean deleteEmployeeByEmpID(int Empid) {
		boolean b1 = false;
		int count = 0;
		Iterator<EmployeeBean> itr = listEmp.iterator();
		while(itr.hasNext()) {
			EmployeeBean eb = (EmployeeBean) itr.next();
			if((int) eb.get_empID() == Empid) {
				li.remove(count);
				listEmp.remove(eb);
				System.out.println(li);
				b1 = true;
				break;
			}
			count += 1;
			
		}
		
		return b1;
	}
		
	public boolean updateEmployeeByEmpId(EmployeeBean bean , float sal) {
		boolean b2 = false;
		Iterator<EmployeeBean> itr1 = listEmp.iterator();
		while(itr1.hasNext()) {
			EmployeeBean eb1 = (EmployeeBean) itr1.next();
			if((int) eb1.get_empID() == bean.get_empID()) {
				eb1.set_salary(sal);
				b2 = true;
			}
		}
		return b2;
	}
	
	public EmployeeBean findEmployeeByEmpID(int empID) {
		Iterator<EmployeeBean> itr2 = listEmp.iterator();
		EmployeeBean eb2 = null;
		while(itr2.hasNext()) {
			EmployeeBean temp_eb = (EmployeeBean) itr2.next();
			if((int) eb2.get_empID() == empID) {
				eb2 = temp_eb;
			}
		}
		return eb2;
	}
	}

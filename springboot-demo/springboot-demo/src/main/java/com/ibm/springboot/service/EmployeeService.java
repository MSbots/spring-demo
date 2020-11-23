package com.ibm.springboot.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.springboot.bean.Employee;
import com.ibm.springboot.mapper.EmployeeMapper;

@Service
public class EmployeeService {
	@Autowired
	EmployeeMapper employeeMapper;

	    public Employee getEmpById(String id) {
	    	return employeeMapper.getEmpById(id);
		};
	    	  	   
	    public void insertEmp(Employee employee) {
	    	employeeMapper.insertEmp(employee);
	    };
	    	 
	    public void updateEmp(Employee employee) {
	    	employeeMapper.updateEmp(employee);
	    };
	    	  
	    public void deleteEmp(String id) {
	    	employeeMapper.deleteEmp(id);
	    };
	}

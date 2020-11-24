package com.ibm.springboot.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.springboot.bean.Employee;
import com.ibm.springboot.mapper.EmployeeMapper;
@Transactional
@Service
public class EmployeeService {
	@Autowired
	EmployeeMapper employeeMapper;

	 	   
	    public void insertEmp(Employee employee) {
	    	employeeMapper.insertEmp(employee);
	    };
	    	 
	    public void updateEmp(Employee employee) {
	    	employeeMapper.updateEmp(employee);
	    };
	    	  
	    public void deleteEmp(int id) {
	    	employeeMapper.deleteEmp(id);
	    };
	    
	    public   List<Employee> findAll(){
	    	return employeeMapper.findAll();
	    }
	}

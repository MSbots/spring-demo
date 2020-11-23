package com.ibm.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ibm.springboot.bean.Employee;

import com.ibm.springboot.mapper.EmployeeMapper;
import com.ibm.springboot.service.EmployeeService;


@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmpController {


	
	@Autowired
	private EmployeeService employeeService;
	

	
	
	/**
	 * 新增员工
	 * @param employee
	 */
	@PostMapping("/insert")
	public String insertEmployee(@RequestBody Employee employee) {
		employeeService.insertEmp(employee);
		return "已新增一名id为"+employee.getId()+"员工";
	}
	
	/**
	 * 查询员工
	 * @param id
	 * @return
	 */
	@GetMapping("/query/{id}")
    public Employee getEmployee(@PathVariable("id") String id){
        return employeeService.getEmpById(id);
    }
	/**
	 * 修改员工信息
	 * @param employee
	 */
	@PutMapping("/update")
    public String updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmp(employee);
         return "update success";
    }
	/**
	 * 根据员工id删除员工
	 * @param id
	 */
	@DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") String id){
		employeeService.deleteEmp(id);
		 return "delete success";
    }
	
}

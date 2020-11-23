package com.ibm.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ibm.springboot.bean.Employee;

import com.ibm.springboot.mapper.EmployeeMapper;



@RestController
public class EmpController {


	
	@Autowired
	private EmployeeMapper employeeMapper;
	

	
	
	/**
	 * 新增员工
	 * @param employee
	 */
	@PostMapping("/employee/insert")
	public String insertEmployee(@RequestBody Employee employee) {
		employeeMapper.insertEmp(employee);
		return "已新增一名id为"+employee.getId()+"员工";
	}
	
	/**
	 * 查询员工
	 * @param id
	 * @return
	 */
	@GetMapping("/employee/query/{id}")
    public Employee getEmployee(@PathVariable("id") String id){
        return employeeMapper.getEmpById(id);
    }
	/**
	 * 修改员工信息
	 * @param employee
	 */
	@PutMapping("/employee/update")
    public String updateEmployee(@RequestBody Employee employee){
        employeeMapper.updateEmp(employee);
         return "update success";
    }
	/**
	 * 根据员工id删除员工
	 * @param id
	 */
	@DeleteMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable("id") String id){
		employeeMapper.deleteEmp(id);
		 return "delete success";
    }
	
}

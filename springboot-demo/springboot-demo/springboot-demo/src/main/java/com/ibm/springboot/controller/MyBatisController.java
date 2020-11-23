package com.ibm.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springboot.bean.Department;
import com.ibm.springboot.bean.Employee;
import com.ibm.springboot.mapper.DepartmentMapper;
import com.ibm.springboot.mapper.EmployeeMapper;

@RestController
public class MyBatisController {

	@Autowired
	private DepartmentMapper departmentMapper;
	@Autowired
	private EmployeeMapper employeeMapper;
	
	/**
	 * 增加部门
	 * @param department
	 * @return
	 */
	@PostMapping("/department/insert")
    public Department insertDept(@RequestBody Department department){
        departmentMapper.insertDept(department);
        return department;
    }
	
	/**
	 * 修改部门
	 * @param department
	 */
	@PutMapping("/department/update")
    public void updateDept(@RequestBody Department department){
        departmentMapper.updateDept(department);
    }
	
	/**
	 * 根据部门id查询部门
	 * @param id
	 * @return
	 */
	@GetMapping("/department/query/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentMapper.getDeptById(id);
    }
	
	/**
	 * 根据部门id删除部门
	 * @param id
	 */
	@DeleteMapping("/department/delete/{id}")
    public void deleteDepartment(@PathVariable("id") Integer id){
        departmentMapper.deleteDeptById(id);
    }
	
	/**
	 * 新增员工
	 * @param employee
	 */
	@PostMapping("/employee/insert")
	public void insertEmployee(@RequestBody Employee employee) {
		employeeMapper.insertEmp(employee);
	}
	
	/**
	 * 查询员工
	 * @param id
	 * @return
	 */
	@GetMapping("/employee/query/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }
}

package com.ibm.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.ibm.springboot.bean.Employee;
import com.ibm.springboot.bean.EmployeeId;
import com.ibm.springboot.mapper.EmployeeMapper;
import com.ibm.springboot.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmpController {


	
	@Autowired
	private EmployeeService employeeService;
	private EmployeeMapper employeeMapper;	
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
	 * 修改员工信息
	 * @param employee
	 */
	@PutMapping("/update")
    public Map<String, Object> updateEmployee(@RequestBody Employee employee){
		log.info("修改员工现信息为：[{}]", employee);
		Map<String,Object> map = new HashMap<>();
	
		try {
			employeeService.updateEmp(employee);
			map.put("state",true);
			map.put("msg","修改员工信息成功");
			map.put("employee",employee);
		} catch (Exception e) {
			map.put("state",false);
			map.put("msg","修改员工信息失败");			
		}		
		 return map;
    }   
	/**
	 * 根据员工id删除员工
	 * @param id
	 */
	@GetMapping("/delete/{id}")
    public Map<String, Object> deleteEmployee(@PathVariable("id") int id){
		log.info("删除员工的ID：[{}]", id);
		Map<String,Object> map = new HashMap<>();
		try {
			employeeService.deleteEmp(id);
			map.put("state",true);
			map.put("msg","删除员工信息成功");
		} catch (Exception e) {
			map.put("state",false);
			map.put("msg","删除员工信息失败");			
		}		
		 return map;
    }	
	
	/**
	 * 查询所有员工
	 * @param all
	 * @return
	 */
	@GetMapping("/findAll")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	/**
	 * 查询所有员工2
	 * @param all
	 * @return
	 */
	 @GetMapping(value="/emplist")
	    public List<Employee> queryList(Model m,@RequestParam(value = "start", defaultValue = "0")int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
		 
	    	        PageHelper.startPage(start,size);     	    	
	    	        return employeeService.queryList();	    	
	    	    }
	 
	 @GetMapping("/Max")
		public List<EmployeeId> MaxID(){
			return employeeService.MaxID();
		}
		
}

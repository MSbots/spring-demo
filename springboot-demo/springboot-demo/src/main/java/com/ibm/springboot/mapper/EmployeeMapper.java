package com.ibm.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ibm.springboot.bean.Employee;
import com.ibm.springboot.bean.EmployeeId;

//@Mapper或者@MapperScan将接口扫描装配到容器中
public interface EmployeeMapper {

	@Options(useGeneratedKeys = true, keyProperty = "id")
	@Insert("INSERT INTO t_emp(id,name,salary,age) VALUES (#{id},#{name},#{salary},#{age})")
	public void insertEmp(Employee employee);

	@Update(" update t_emp set \r\n" + "    name=#{name},\r\n" + "    salary=#{salary},\r\n" + "    age=#{age}\r\n"
			+ "    where id=#{id}")
	public int updateEmp(Employee employee);

	@Delete(" delete from t_emp where id=#{id}")
	public int deleteEmp(int id);

	@Select("select id,name,salary,age from t_emp")
	public List<Employee> findAll();

	@Select("select * from t_emp ")
	public List<Employee> queryList();

	@Select("select id,name,salary,age from t_emp limit #{currentPage},5")
	public List<Employee> getempByPage(Integer currentPage);

	@Select("select COUNT(ID) max from t_emp ")
	public List<EmployeeId> MaxID();
}

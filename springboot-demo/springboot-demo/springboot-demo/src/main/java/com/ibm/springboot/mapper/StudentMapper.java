package com.ibm.springboot.mapper;

import com.ibm.springboot.bean.Student;


public interface StudentMapper {

	 public  Student getStuById(Integer id);

	    public void insertStu(Student student);
	    
		public void updateStu(Student student);

		public void deleteStuById(Integer id);
	}



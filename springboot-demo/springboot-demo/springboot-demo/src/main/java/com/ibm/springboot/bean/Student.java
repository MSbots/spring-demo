package com.ibm.springboot.bean;

public class Student {
	private Integer id;
	private String Name;
	private Integer age;
	private Integer stuno;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getStuno() {
		return stuno;
	}
	public void setStuno(Integer stuno) {
		this.stuno = stuno;
	}
	
}

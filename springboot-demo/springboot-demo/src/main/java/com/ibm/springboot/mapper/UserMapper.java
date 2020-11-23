package com.ibm.springboot.mapper;

import org.apache.ibatis.annotations.*;

import com.ibm.springboot.bean.User;




//指定这是一个操作数据库的mapper
//@Mapper或者@MapperScan将接口扫描装配到容器中
public interface UserMapper {
//
//	@Select("select * from t_user where id=#{id}")
//	public User getUserById(Integer id);

	@Delete("delete from t_user where id=#{id}")
	public int deleteUserById(Integer id);

	@Options(useGeneratedKeys = true, keyProperty = "id")
	@Insert("insert into t_user(username,realname,password,sex) values(#{userName},#{realName},#{password},#{sex})")
	public int insertUser(User user);

	@Update("update t_user set username=#{userName},realname=#{realName},password=#{password} ,sex=#{sex} where id=#{id}")
	public int updateUser(User user);
	
	@Select("select * from t_user where username=#{username}")
    User findByUserName(String username);
	
}
 

package com.ibm.springboot.mapper;

import org.apache.ibatis.annotations.*;

import com.ibm.springboot.bean.User;




//指定这是一个操作数据库的mapper
//@Mapper或者@MapperScan将接口扫描装配到容器中
public interface UserMapper {

//插入User
	@Options(useGeneratedKeys = true, keyProperty = "id")
	@Insert("insert into t_user(username,realname,password,sex) values(#{userName},#{realName},#{password},#{sex})")
	public int insertUser(User user);


//根据用户名查找User
	@Select("select id,username,realname,password,sex from t_user where username=#{username}")
    User findByUserName(String username);
	
}
 

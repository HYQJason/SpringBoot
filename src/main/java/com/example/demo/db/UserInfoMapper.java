package com.example.demo.db;

import com.example.demo.bean.UsreInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserInfoMapper {
    @Insert("insert into users(name, age,id,account) values(#{name}, #{age},#{id},#{account})")
    public int insertUser(UsreInfo user);
    @Delete("delete from users where id=#{id}")
    public int deleteUserById(int id);
    @Update("update users set name=#{name},age=#{age},name=#{id},name=#{account} where id=#{id}")
    public int updateUser(UsreInfo user);
    @Select("select * from users where id=#{id}")
    public UsreInfo getUserById(int id);
    @Select("select * from users")
    public List<UsreInfo> getAllUser();

}

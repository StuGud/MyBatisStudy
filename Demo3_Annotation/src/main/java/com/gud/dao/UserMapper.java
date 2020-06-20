package com.gud.dao;

import com.gud.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by david.w on 2020/6/17.
 */

//等价于mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> getUserList();

    @Select("select *from user where id=#{id}")
    User getUserById(@Param("id")int id);

    @Insert("insert into user(id,name,pwd) values (#{id},#{name},#{pwd})")
    int addUser(User user);

    @Update("update user set name=#{name},pwd=#{pwd} where id=#{id}")
    int updateUser(User user);

    //引用的名称一致时可以不加@Param()
    @Delete("delete from user where id=#{id}")
    int deleteUser(int id);
}

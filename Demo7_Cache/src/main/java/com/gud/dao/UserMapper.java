package com.gud.dao;

import com.gud.pojo.User;
import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by david.w on 2020/6/21.
 */

@CacheNamespaceRef(UserMapper.class)
public interface UserMapper {
    @Select("select * from user where id=#{id}")
    User queryUserById(int id);

    @Update("update user set name=#{name},pwd=#{pwd} where id=#{id}")
    int updateUser(User user);
}

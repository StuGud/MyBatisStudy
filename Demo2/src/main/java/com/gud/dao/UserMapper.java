package com.gud.dao;

import com.gud.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * Created by david.w on 2020/6/17.
 */

//等价于mapper
public interface UserMapper {
    /**
     * 查询全部用户
     */
    List<User> getUserList();
    /**
     * 根据id查询用户
     */
    User getUserById(int id);
    /**
     * 分页
     */
    List<User> getUserByLimit(Map<String,Integer> map);
    /**
     *RowBounds分页
     */
    List<User> getUserByRowBounds();
}

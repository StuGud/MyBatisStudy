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
     * insert用户
     */
    int insertUser(User user);
    /**
     * 修改
     */
    int updateUser(User user);
    /**
     * 删除
     */
    int deleteUser(int id);
    /**
     * 小技巧 传参map
     */
    int insertUserByMap(Map<String,Object> map);
    /**
     * 模糊查询
     */
    List<User> getUserLike(String value);
}

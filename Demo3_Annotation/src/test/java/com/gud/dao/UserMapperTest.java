package com.gud.dao;

import com.gud.pojo.User;
import com.gud.utils.MyBatisUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by david.w on 2020/6/18.
 */

public class UserMapperTest {

    @Test
    public void testGetUserList(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //底层主要应用反射
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();
        for (User user :
                userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
       User user = userMapper.getUserById(1);

            System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void testAddUser(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.addUser(new User(5,"person5","password5"));
        sqlSession.close();
    }

    @Test
    public void testUpdateUser(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser(new User(5,"personNew","passwordNew"));
        sqlSession.close();
    }

    @Test
    public void testDeleteUser(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser(5);
        sqlSession.close();
    }
}

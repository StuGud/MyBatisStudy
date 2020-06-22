package com.gud.dao;

import com.gud.pojo.User;
import com.gud.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by david.w on 2020/6/21.
 */

public class UserMapperTest {

    @Test
    public void testSqlSessionCache1() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user1 = userMapper.queryUserById(1);
        System.out.println(user1);
        System.out.println("=================================");
        User user2 = userMapper.queryUserById(1);
        System.out.println(user2);
        System.out.println("=================================");
        System.out.println(user1==user2);
        sqlSession.close();
    }


    @Test
    public void testSqlSessionCache2() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user1 = userMapper.queryUserById(1);
        System.out.println(user1);
        System.out.println("=================================");
        userMapper.updateUser(new User(2,"22","222"));
        System.out.println("=================================");
        User user2 = userMapper.queryUserById(1);
        System.out.println(user2);
        System.out.println("=================================");
        System.out.println(user1==user2);
        sqlSession.close();
    }

    @Test
    public void testNamespaceCache() {
        SqlSession sqlSession1 = MyBatisUtil.getSqlSession();
        SqlSession sqlSession2 = MyBatisUtil.getSqlSession();

        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = userMapper1.queryUserById(1);
        System.out.println(user1);
        sqlSession1.close();
        System.out.println("=================================");

        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = userMapper2.queryUserById(1);
        System.out.println(user2);
        sqlSession2.close();
        System.out.println("=================================");

        System.out.println(user1==user2);
    }

    @Test
    public void test(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        SqlSession sqlSession1 = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryUserById(1);
        System.out.println(user);
        sqlSession.close();

        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = userMapper1.queryUserById(1);
        System.out.println(user1);
        System.out.println(user==user1);
        sqlSession1.close();
    }
}
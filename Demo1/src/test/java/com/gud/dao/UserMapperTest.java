package com.gud.dao;

import com.gud.pojo.User;
import com.gud.utils.MyBatisUtil;
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
        //获得sqlSession对象
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //方式一：getMapper    动态代理和反射机制？？？
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();

        //方式二
        //List<User> userList = sqlSession.selectList("com.com.com.gud.dao.UserDao.getUserList");

        for(User user:userList){
            System.out.println(user);
        }
        //关闭sqlSession
        sqlSession.close();


    }

    @Test
    public void testGetUserById(){
        SqlSession sqlSession =null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserById(1);

            System.out.println(user);
        }finally {
            sqlSession.close();
        }
    }

    //增删改需要提交事务
    @Test
    public void testInsertUser(){
        SqlSession sqlSession =null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.insertUser(new User(4,"person4","444444"));

            List<User> userList = userMapper.getUserList();
            for(User user:userList){
                System.out.println(user);
            }
        }finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    //增删改需要提交事务
    @Test
    public void testUpdateUser(){
        SqlSession sqlSession =null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.updateUser(new User(4,"newName","444444"));

            List<User> userList = userMapper.getUserList();
            for(User user:userList){
                System.out.println(user);
            }
        }finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    //增删改需要提交事务
    @Test
    public void testDeleteUser(){
        SqlSession sqlSession =null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.deleteUser(4);

            List<User> userList = userMapper.getUserList();
            for(User user:userList){
                System.out.println(user);
            }
        }finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void testInsertUserByMap(){
        SqlSession sqlSession =null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            Map<String,Object> map=new HashMap<String,Object>();
            map.put("mapId",8);
            map.put("mapName","person8");
            map.put("mapPwd","888888");
            userMapper.insertUserByMap(map);

            List<User> userList = userMapper.getUserList();
            for(User user:userList){
                System.out.println(user);
            }
        }finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void testGetUserLike(){
        SqlSession
            sqlSession = MyBatisUtil.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            List<User> userList = userMapper.getUserLike("name");
            for(User user:userList){
                System.out.println(user);
            }
        //sqlSession =null;
        //try {
        //}finally {
            sqlSession.commit();
            sqlSession.close();
        //}
    }
}

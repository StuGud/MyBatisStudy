package com.gud.dao;

import com.gud.pojo.User;
import com.gud.utils.MyBatisUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by david.w on 2020/6/18.
 */

public class UserMapperTest {

    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void testGetUserList(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();
        for(User user:userList){
            System.out.println(user);
        }
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

    @Test
    public void testLog4j(){
        logger.info("info：执行testLog4j");
        logger.debug("debug：执行testLog4j");
        logger.error("error：执行testLog4j");
    }

    @Test
    public void testGetUserByLimit(){
        SqlSession sqlSession =null;
        try {
            sqlSession = MyBatisUtil.getSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            Map<String,Integer> map=new HashMap<String,Integer>();
            map.put("startIndex",0);
            map.put("pageSize",2);

            List<User> userList = userMapper.getUserByLimit(map);
            for(User user:userList){
                System.out.println(user);
            }
        }finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void testGetUserByRowBounds(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

            RowBounds rowBounds = new RowBounds(1, 2);

            //Java代码层面实现分页
            List<User> userList = sqlSession.selectList("com.com.com.gud.dao.UserMapper.getUserByRowBounds",null,rowBounds);
            for(User user:userList){
                System.out.println(user);
            }

            sqlSession.close();

    }
}

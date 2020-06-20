package com.gud.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by david.w on 2020/6/17.
 */

public class MyBatisUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static{
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(){
        //try (SqlSession session = sqlSessionFactory.openSession()) {
        //    BlogMapper mapper = session.getMapper(BlogMapper.class);
        //    Blog blog = mapper.selectBlog(101);
        //}
        return sqlSessionFactory.openSession();
    }
}

package com.gud.dao;

import com.gud.pojo.Teacher;
import com.gud.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by david.w on 2020/6/18.
 */

public class TeacherMapperTest {
    @Test
    public void testGetTeacherById(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.getTeacherById(1);
        System.out.println(teacher);
        sqlSession.close();
    }
}

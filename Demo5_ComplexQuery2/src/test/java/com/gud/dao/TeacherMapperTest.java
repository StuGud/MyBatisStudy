package com.gud.dao;

import com.gud.pojo.Teacher;
import com.gud.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by david.w on 2020/6/20.
 */

public class TeacherMapperTest {

    @Test
    public void getTeacherList() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teacherList = teacherMapper.getTeacherList();
        for (Teacher teacher :
                teacherList) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }

    @Test
    public void getTeacherById() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.getTeacherById(1);
        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void getTeacherById2() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.getTeacherById2(1);
        System.out.println(teacher);
        sqlSession.close();
    }
}
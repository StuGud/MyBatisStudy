package com.gud.dao;

import com.gud.pojo.Student;
import com.gud.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by david.w on 2020/6/20.
 */

public class StudentMapperTest {

    @Test
    public void getStudentList() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = studentMapper.getStudentList();
        for (Student student :
                studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void getStudentList2() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = studentMapper.getStudentList2();
        for (Student student :
                studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
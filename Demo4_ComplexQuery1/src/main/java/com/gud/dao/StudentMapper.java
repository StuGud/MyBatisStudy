package com.gud.dao;

import com.gud.pojo.Student;
import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * Created by david.w on 2020/6/20.
 */

public interface StudentMapper {
    /**
     * 查询所有学生信息，以及对应的老师的信息
     */
    List<Student> getStudentList();
    List<Student> getStudentList2();


}

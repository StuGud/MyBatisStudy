package com.gud.dao;

import com.gud.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by david.w on 2020/6/20.
 */

public interface TeacherMapper {
    List<Teacher> getTeacherList();

    /**
     * 获取指定老师及其所有学生信息 按结果
     */
    Teacher getTeacherById(@Param("tid") int id);
    /**
     * 获取指定老师及其所有学生信息 按查询
     */
    Teacher getTeacherById2(@Param("tid") int id);
}

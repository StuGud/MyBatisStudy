package com.gud.dao;

import com.gud.pojo.Teacher;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.Alias;

/**
 * Created by david.w on 2020/6/20.
 */

public interface TeacherMapper {

    @Select("select * from teacher where id=#{id}")
    Teacher getTeacherById(int id);
}

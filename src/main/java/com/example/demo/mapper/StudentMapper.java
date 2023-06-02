package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.Course;
import com.example.demo.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    @Select("select * from tb_course tc " +
            "left join tb_course_student tcs on tc.cid = tcs.cid " +
            "left join tb_student ts on tcs.sid = ts.sid " +
            "where ts.sid = #{sid}")
    List<Course> findCoursesByStudentId(String sid);

    @Select("select * from tb_student where sid = #{sid}")
    Student selectBySid(String sid);
}

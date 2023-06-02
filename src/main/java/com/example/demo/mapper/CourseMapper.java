package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.Course;
import com.example.demo.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    @Select("select * from tb_student ts " +
            "left join tb_course_student tcs on ts.sid = tcs.sid " +
            "left join tb_course tc on tcs.cid = tc.cid " +
            "where tc.cid = #{cid}")
    List<Student> findStudentsByCourseId(String cid);

    @Select("select * from tb_course where cid = #{cid}")
    Course selectByCidCourse(String cid);


}

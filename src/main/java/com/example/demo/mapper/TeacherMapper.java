package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.Course;
import com.example.demo.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {
//    @Select("select * from tb_course c left join tb_teacher t on c.teacher_id = #{tid}")
    @Select("")
    List<Course> findCoursesByTeacherId(Integer tid);

    @Select("select * from tb_teacher where tid = #{tid}")
    Teacher searchByTidTeacher(String tid);
}

package com.example.demo.service.Impl;

import com.example.demo.common.SignInStatus;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.mapper.TeacherMapper;
import com.example.demo.pojo.Course;
import com.example.demo.pojo.Teacher;
import com.example.demo.service.TeacherService;
import jakarta.servlet.ServletContext;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Service
public class teacherServiceImpl implements TeacherService {
    @Mapper
    private CourseMapper courseMapper;
    @Mapper
    private TeacherMapper teacherMapper;

    @Override
    public String startSignIn(Teacher teacher, Course course, ServletContext servletContext,Integer time) {

        return new SignInStatus().startSignIn(course,teacher,servletContext, courseMapper,time);
    }

    @Override
    public Teacher getEntity(String tid) {
        return teacherMapper.searchByTidTeacher(tid);
    }

}

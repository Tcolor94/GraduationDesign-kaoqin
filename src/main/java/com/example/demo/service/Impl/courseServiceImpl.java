package com.example.demo.service.Impl;

import com.example.demo.mapper.CourseMapper;
import com.example.demo.pojo.Course;
import com.example.demo.service.CourseService;
import org.apache.ibatis.annotations.Mapper;


public class courseServiceImpl implements CourseService {
    @Mapper
    private CourseMapper courseMapper;
    @Override
    public Course searchByCidCourse(String cid) {
        return courseMapper.selectByCidCourse(cid);
    }
}

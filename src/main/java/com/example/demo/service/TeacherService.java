package com.example.demo.service;


import com.example.demo.pojo.Course;
import com.example.demo.pojo.Teacher;
import jakarta.servlet.ServletContext;


public interface TeacherService {
    String startSignIn(Teacher teacher, Course course, ServletContext servletContext, Integer time);

    Teacher getEntity(String tid);
}

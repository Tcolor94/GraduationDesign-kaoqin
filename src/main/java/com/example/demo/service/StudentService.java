package com.example.demo.service;

import com.example.demo.pojo.Student;
import jakarta.servlet.ServletContext;


public interface StudentService {
    String toSignIn(String sid, String cid, ServletContext servletContext);

    String signIn(String sid, String cid, String code, ServletContext servletContext);

    Student getEntity(String sid);
}

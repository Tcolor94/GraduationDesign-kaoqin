package com.example.demo.service.Impl;

import com.example.demo.common.SignInStatus;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.mapper.SignInRecordMapper;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.pojo.Course;
import com.example.demo.pojo.SignInRecord;
import com.example.demo.pojo.Student;
import com.example.demo.service.StudentService;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentServiceImpl implements StudentService {
    @Autowired
    private SignInRecordMapper signInRecordMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CourseMapper courseMapper;


    @Override
    public String toSignIn(String sid, String cid, ServletContext servletContext) {
        Course course = courseMapper.selectByCidCourse(cid);
        String result = "0";
        List<SignInStatus> taskList = (List<SignInStatus>) servletContext.getAttribute(course.getName());

        if (taskList != null) {
            for (SignInStatus s : taskList) {
                if (s.getSid().equals(sid)) {
                    result = "1";
                    break;
                }
            }
        }
        return result;
    }


    @Override

    public String signIn(String sid, String cid, String code, ServletContext servletContext) {
        // 获取课程和学生对象
        Course course = courseMapper.selectByCidCourse(cid);
        Student student = studentMapper.selectBySid(sid);

        List<SignInStatus> taskList = (List<SignInStatus>) servletContext.getAttribute(course.getName());
        for (SignInStatus status : taskList) {
            //逻辑有问题，需要先判断code的一致性，再依次查找学号匹配的学生
            if (status.getCode().equals(code) && status.getSid().equals(student.getSid())) {
                SignInRecord signInRecord = new SignInRecord();
                signInRecord.setStudentId(student.getSid());
                signInRecord.setGroupId(student.getGroupId());
                long time = System.currentTimeMillis();
                if (time - status.getStartTime() <= status.getTime() * 1000) {
                    signInRecord.setStatus("正常");
                } else {
                    signInRecord.setStatus("迟到");
                }
                signInRecord.setTeacherId(course.getTeacherId());
                signInRecord.setCourseId(course.getCid());
                return signInRecordMapper.addRecord(signInRecord).toString();
            }
        }
        return "0";
    }

    @Override
    public Student getEntity(String sid) {
        return studentMapper.selectBySid(sid);
    }


}

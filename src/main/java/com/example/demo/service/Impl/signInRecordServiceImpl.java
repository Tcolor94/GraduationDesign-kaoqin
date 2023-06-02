package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.SignInRecordMapper;
import com.example.demo.pojo.SignInRecord;
import com.example.demo.service.SignInRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class signInRecordServiceImpl implements SignInRecordService {
    @Autowired
    private SignInRecordMapper signInRecordMapper;
    @Override
    public String addRecord(SignInRecord signInRecord) {
        Integer result = signInRecordMapper.addRecord(signInRecord);
        return Integer.toString(result);
    }

    @Override
    public String modifyRecord(String sid, String cid, String status) {
        QueryWrapper<SignInRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_id",sid)
                .eq("course_id",cid);
        SignInRecord signInRecord = signInRecordMapper.selectOne(queryWrapper);
        signInRecord.setStatus(status);
        int update = signInRecordMapper.update(signInRecord, queryWrapper);
        return Integer.toString(update);
    }


}

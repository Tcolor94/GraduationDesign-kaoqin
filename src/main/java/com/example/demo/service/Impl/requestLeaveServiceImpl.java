package com.example.demo.service.Impl;

import com.example.demo.mapper.RequestLeaveMapper;
import com.example.demo.service.RequestLeaveService;
import org.apache.ibatis.annotations.Mapper;

public class requestLeaveServiceImpl implements RequestLeaveService {
    @Mapper
    private RequestLeaveMapper requestLeaveMapper;

    @Override
    public Integer addRequest(String sid, String startTime, String endTime, String reason) {
        return requestLeaveMapper.addRequest(sid, startTime, endTime, reason);
    }
}

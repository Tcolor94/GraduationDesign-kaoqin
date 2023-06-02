package com.example.demo.service.Impl;

import com.example.demo.mapper.AdminMapper;
import com.example.demo.pojo.Admin;
import com.example.demo.service.AdminService;
import org.apache.ibatis.annotations.Mapper;

public class adminServiceImpl implements AdminService {
    @Mapper
    private AdminMapper adminMapper;

    @Override
    public Admin getEntity(String aid) {
        return adminMapper.getEntity(aid);
    }
}

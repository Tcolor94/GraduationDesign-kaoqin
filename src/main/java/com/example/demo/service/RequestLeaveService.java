package com.example.demo.service;

public interface RequestLeaveService {
    Integer addRequest(String sid,String startTime,String endTime,String reason);
}

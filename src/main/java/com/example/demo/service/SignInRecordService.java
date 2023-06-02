package com.example.demo.service;

import com.example.demo.pojo.SignInRecord;

public interface SignInRecordService {
    String addRecord(SignInRecord signInRecord);
    String modifyRecord(String sid,String cid,String status);
}

package com.example.demo.common;

import com.baomidou.mybatisplus.extension.plugins.handler.TableNameHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CourseSignRecordTableNameHandler implements TableNameHandler {
    @Override
    public String dynamicTableName(String sql, String tableName) {
        String dateDay = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        return tableName + "_" + dateDay;
    }
}

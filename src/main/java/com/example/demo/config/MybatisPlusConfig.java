package com.example.demo.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.DynamicTableNameInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.example.demo.common.CourseSignRecordTableNameHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;
import java.util.Collections;

@Configuration

public class MybatisPlusConfig {
//    @Bean
//    public MybatisPlusInterceptor mybatisPlusInterceptor() {
//        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
//
//        DynamicTableNameInnerInterceptor dynamicTableNameInnerInterceptor = new DynamicTableNameInnerInterceptor();
//        //添加上自己实现的表名处理器
//        dynamicTableNameInnerInterceptor.setTableNameHandler(new CourseSignRecordTableNameHandler());
//        interceptor.addInnerInterceptor(dynamicTableNameInnerInterceptor);
//
//        return interceptor;
//    }
/**
 * dynamicTableNameParser.setTableNameHandlerMap(new HashMap<String, ITableNameHandler>(2) {{
 *             put("user_info", (metaObject, sql, tableName) -> {
 *                 // 获取传入参数 year，如果有的话做为后缀，没有的话则使用当前年份作为后缀
 *                 Object param = getParamValue("year", metaObject);
 *                 String year = param !=null ? String.valueOf(param)
 *                         : String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
 *                 return tableName + "_" + year;
 *             });
 *         }});
 *         paginationInterceptor.setSqlParserList(Collections.singletonList(dynamicTableNameParser));
 *         return paginationInterceptor;
 */

}

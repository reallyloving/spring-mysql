package com.example.springmysql.dao;

import com.example.springmysql.entity.ExcelData;
import com.example.springmysql.entity.ExcelFile;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by yad on 2018/1/24.
 */

@Mapper
public interface ExcelDataMapper {
    //添加数据到数据库
    @Insert("insert into test(number,question,preclassification,currentclassification,taggingperson) values(#{number},#{question},#{preclassification},#{currentclassification},#{taggingperson})")
    void addExcel(ExcelData exceldata);

    //查询数据
    @Select("select * from test where number = #{number}")
    ExcelData selectUserById(int number);

    //上传文件信息
    @Insert("insert into excelforms(name,path) values(#{name},#{path})")
    int addExcelForms(ExcelFile excelFile);
}

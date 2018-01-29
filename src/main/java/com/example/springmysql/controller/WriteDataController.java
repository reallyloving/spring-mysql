package com.example.springmysql.controller;

import com.example.springmysql.dao.ExcelDataMapper;
import com.example.springmysql.entity.ExcelData;
import com.example.springmysql.entity.ExcelFile;
import com.example.springmysql.tool.ExcelListData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

/**
 * Created by yad on 2018/1/24.
 */
@RestController
@RequestMapping("/excel")
public class WriteDataController {

    @Autowired
    private ExcelDataMapper dataMapper;

    @RequestMapping("/save")
    @Transactional
    public String save(){
        ExcelListData excelListData = new ExcelListData();
        List<ExcelData> excelDataList = excelListData.writeData("E:/BaiduNetdiskDownload/基础标注1220-王彪.xlsx");
        for (int i =0;i<excelDataList.size();i++){
            dataMapper.addExcel(excelDataList.get(i));
        }
        return "successful";
    }
    //上传文件并写入数据库
    @ResponseBody
    @Transactional
    @RequestMapping("/add")
    public String addExcelForms(String name,String path){
        ExcelFile excelFile = new ExcelFile();
        excelFile.setName(name);
        excelFile.setPath(path);
        int t = dataMapper.addExcelForms(excelFile);
        if (t==1){
            ExcelListData excelListData = new ExcelListData();
            List<ExcelData> excelDataList = excelListData.writeData(path);
            for (int i =0;i<excelDataList.size();i++){
                dataMapper.addExcel(excelDataList.get(i));
            }
            return "successful";
        }else {
            return "false";
        }
    }
    //按照序列号查询
    @RequestMapping(value = {"/selectid"},method = RequestMethod.GET)
    public ExcelData selectUserById(String number){
        ExcelData excelData = dataMapper.selectUserById(Integer.parseInt(number));
        return excelData;
    }


}

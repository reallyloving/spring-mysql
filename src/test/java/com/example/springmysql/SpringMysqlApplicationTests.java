package com.example.springmysql;

import com.example.springmysql.dao.ExcelDataMapper;
import com.example.springmysql.entity.ExcelData;
import com.example.springmysql.tool.ExcelListData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMysqlApplicationTests {
	@Autowired
	private ExcelDataMapper excelDataMapper;
	@Test
	public void contextLoads() {
	}
	@Test
//	@Transactional
	public void test(){
		ExcelListData excelListData = new ExcelListData();
		List<ExcelData> excelDataList = excelListData.writeData("C:/Users/jrwangbiao/Desktop/标注/基础标注1220-王彪.xlsx");
		for (int i =0;i<excelDataList.size();i++){
			excelDataMapper.addExcel(excelDataList.get(i));
		}
	}
}

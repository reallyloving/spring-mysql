package com.example.springmysql.tool;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Created by yad on 2018/1/24.
 */
public class AnalysisExcel {
    private Logger logger = LoggerFactory.getLogger(AnalysisExcel.class);
    private Workbook wb;
    private Sheet sheet;
    private Row row;

    public AnalysisExcel(String filepath) {
        if(filepath==null){
            return;
        }
        String ext = filepath.substring(filepath.lastIndexOf("."));
        try {
            InputStream is = new FileInputStream(filepath);
            if(".xls".equals(ext)){
                wb = new HSSFWorkbook(is);
            }else if(".xlsx".equals(ext)){
                wb = new XSSFWorkbook(is);
            }else{
                wb=null;
            }
        } catch (FileNotFoundException e) {
            logger.error("FileNotFoundException", e);
        } catch (IOException e) {
            logger.error("IOException", e);
        }
    }

    /**
     * 读取Excel表格表头的内容
     *
     * @return String 表头内容的数组
     */
    public String[] readExcelTitle() throws Exception{
        if(wb==null){
            throw new Exception("Workbook对象为空！");
        }
        sheet = wb.getSheetAt(0);
        row = sheet.getRow(0);
        // 标题总列数
        int colNum = row.getPhysicalNumberOfCells();
        System.out.println("colNum:" + colNum);
        String[] title = new String[colNum];
        for (int i = 0; i < colNum; i++) {
            title[i] = row.getCell(i).getCellFormula();
        }
        return title;
    }

    /**
     * 读取Excel数据内容
     *
     * @return Map 包含单元格数据内容的Map对象
     */
    public Map<Integer, Map<Integer,Object>> readExcelContent() throws Exception{
        if(wb==null){
            throw new Exception("Workbook对象为空！");
        }
        Map<Integer, Map<Integer,Object>> content = new HashMap<Integer, Map<Integer,Object>>();

        sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            int j = 0;
            Map<Integer,Object> cellValue = new HashMap<Integer, Object>();
            while (j < colNum) {
                Object object = row.getCell(j);
                cellValue.put(j, object);
                j++;
            }
            content.put(i, cellValue);
        }
        return content;
    }
}

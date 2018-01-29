package com.example.springmysql.tool;

import com.example.springmysql.entity.ExcelData;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yad on 2018/1/24.
 */
public class ExcelListData {
    public List<ExcelData> writeData(String path){
        ExcelData excelData = new ExcelData();
        List<ExcelData> list = new ArrayList<ExcelData>();
        AnalysisExcel analysisExcel = new AnalysisExcel(path);
        try {
            Map<Integer, Map<Integer,Object>> map = analysisExcel.readExcelContent();
            //获得Excel表格的内容:
            for (int i = 1; i <= map.size(); i++) {
                for (int j =0;j<=map.get(i).size();j++){
                    excelData.setNumber(map.get(i).get(0).toString());
                    excelData.setQuestion( map.get(i).get(1).toString());
                    excelData.setPreclassification(map.get(i).get(2).toString());
                    if (null==map.get(i).get(3)) {
                        excelData.setCurrentclassification(null);
                    }
                    excelData.setTaggingperson( map.get(i).get(4).toString());
                }
                list.add(new ExcelData(excelData.getNumber(),excelData.getQuestion(),excelData.getPreclassification(),excelData.getCurrentclassification(),excelData.getTaggingperson()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("未找到指定路径的文件!");
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}


package com.example.springmysql.entity;

/**
 * Created by yad on 2018/1/25.
 */
public class ExcelFile {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private String path;
}

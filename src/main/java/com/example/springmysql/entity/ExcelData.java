package com.example.springmysql.entity;

import java.io.Serializable;


/**
 * Created by yad on 2018/1/24.
 */

public class ExcelData implements Serializable {
    private String number;
    private String question;
    private String preclassification;
    private String currentclassification;
    private String taggingperson;

    public ExcelData(){
        super();
    }
    public ExcelData(String number,String question,String preclassification,String currentclassification,String taggingperson){
        this.number = number;
        this.question = question;
        this.preclassification = preclassification;
        this.currentclassification = currentclassification;
        this.taggingperson = taggingperson;
    }
    public String getNumber() {
        return number;
    }

    public String getCurrentclassification() {
        return currentclassification;
    }

    public void setCurrentclassification(String currentclassification) {
        this.currentclassification = currentclassification;
    }

    public String getTaggingperson() {
        return taggingperson;
    }

    public void setTaggingperson(String taggingperson) {
        this.taggingperson = taggingperson;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getPreclassification() {
        return preclassification;
    }

    public void setPreclassification(String preclassification) {
        this.preclassification = preclassification;
    }
}

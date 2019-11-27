package com.company;

public class Exam {
    private int mark;
    private String subject;

    Exam(int Mark,String Subject){
        mark = Mark;
        subject = Subject;
    }

    Exam(){
    }

    public int getMark(){
        return mark;
    }

    public String getSubject(){
        return subject;
    }

    public void setMark(int Mark){
        this.mark = Mark;
    }

    public void setSubject(String Subject){
        this.subject = Subject;
    }

}

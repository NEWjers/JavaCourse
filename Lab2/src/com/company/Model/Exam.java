package com.company.Model;

import com.company.Validator.MinZNO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Exam {

    @MinZNO(value = 100 , message = "Mark can't be smaller than 100")
    @NotNull
    private int mark;

    @NotNull
    @Size(min = 1 , max = 100 , message = "Subject can't be longer than 100")
    private String subject;

    public Exam(int Mark, String Subject){
        mark = Mark;
        subject = Subject;
    }

    public Exam(){
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

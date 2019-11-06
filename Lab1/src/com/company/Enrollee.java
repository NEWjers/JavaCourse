package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Enrollee {
    private String name;
    private String surname;
    private LocalDate birthday;
    private List<Exam> zno; // List<>

    public static class Builder{
        private Enrollee newEnrollee;

        public Builder(){
            newEnrollee = new Enrollee();
        }

        public Builder withName(String name){
            newEnrollee.name = name;
            return this;
        }

        public Builder withSurname(String surname){
            newEnrollee.surname = surname;
            return this;
        }

        public Builder withBirthDay(int year,int month, int day){
            newEnrollee.birthday.of(year,month,day);
            return this;
        }

        public Builder withZNO(Exam zno1,Exam zno2,Exam zno3){
            newEnrollee.zno = new ArrayList<Exam>();
            newEnrollee.zno.add(zno1);
            newEnrollee.zno.add(zno2);
            newEnrollee.zno.add(zno3);
            return this;
        }


        public Enrollee build(){
            return newEnrollee;
        }
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public LocalDate getBirthday(){
        return birthday;
    }

    Exam getZNO1(){
        return zno.get(0);
    }

    Exam getZNO2(){
        return zno.get(1);
    }

    Exam getZNO3(){
        return zno.get(2);
    }

    void setName(String name){
        this.name = name;
    }

    void setSurname(String surname){
        this.surname = surname;
    }

    void setBirthday(int year,int month,int day){
        this.birthday.of(year,month,day);
    }

    void setMarkBySubject(String subject,int mark){
        for(Exam it:zno){
            if(it.getSubject()==subject)
                it.setMark(mark);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enrollee enrollee = (Enrollee) o;
        return Objects.equals(name, enrollee.name) &&
                Objects.equals(surname, enrollee.surname) &&
                Objects.equals(birthday, enrollee.birthday) &&
                Objects.equals(zno, enrollee.zno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthday, zno);
    }

    float averageZNO(){
        int sum = 0;
        for (Exam exam:zno) {
            sum += exam.getMark();
        }
        return sum/zno.size();
    }
    
    public int getMarkBySubject(String subject){
        for (Exam it:zno) {
            if(it.getSubject()==subject)
                return it.getMark();
            }
        return -1;
        }
    }





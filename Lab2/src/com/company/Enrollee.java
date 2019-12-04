package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Enrollee implements Comparable<Enrollee> {
    private String name;
    private String surname;
    private String birthday;
    private List<Exam> zno; // List<>

    @Override
    public int compareTo(Enrollee o) {
        return (int)this.averageZNO() - (int)o.averageZNO();
    }

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

        public Builder withBirthDay(String birthDay){
            newEnrollee.birthday = birthDay;
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

    public String getBirthday(){
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

    public List<Exam> getZno() {
        return zno;
    }

    void setName(String name){
        this.name = name;
    }

    void setSurname(String surname){
        this.surname = surname;
    }

    void setBirthday(String birthday){
        this.birthday = birthday;
    }

    void setMarkBySubject(String subject,int mark){
        for(Exam it:zno){
            if(it.getSubject()==subject)
                it.setMark(mark);
        }
    }

    void setZNO(String subject, int mark,int index){
        int i = 0;
        for(Exam it:zno){
            if(i==index-1) {
                it.setMark(mark);
                it.setSubject(subject);
            }
            i++;
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




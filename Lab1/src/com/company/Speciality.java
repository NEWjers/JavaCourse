package com.company;

import java.util.ArrayList;
import java.util.List;

public class Speciality {
    private String name;
    private List<Exam> minZNO;

    public static class Builder{
        private Speciality newSpeciality;
        public Builder(){
            newSpeciality = new Speciality();
        }

        public Builder withName(String name){
            newSpeciality.name = name;
            return this;
        }

        public Builder withZNO(Exam zno1,Exam zno2,Exam zno3){
            newSpeciality.minZNO = new ArrayList<Exam>();
            newSpeciality.minZNO.add(zno1);
            newSpeciality.minZNO.add(zno2);
            newSpeciality.minZNO.add(zno3);
            return this;
        }

        public Speciality build(){
            return newSpeciality;
        }

    }

    public String getName(){
        return name;
    }

    public Exam getzno1(){
        return minZNO.get(0);
    }

    public Exam getSubject2(){
        return minZNO.get(1);
    }

    public Exam getSubject3(){
        return minZNO.get(2);
    }

    public void setName(String name){
        this.name = name;
    }

    public void setZNO1(Exam zno1){
        this.minZNO.remove(0);
        this.minZNO.set(0,zno1);
    }

    public void setZNO2(Exam zno2){
        this.minZNO.remove(1);
        this.minZNO.set(1,zno2);
    }

    public void setZNO3(Exam zno3){
        this.minZNO.remove(2);
        this.minZNO.set(2,zno3);
    }

    public boolean checkEnrollee(Enrollee Ob){
        return (Ob.getMarkBySubject(minZNO.get(0).getSubject()) >= minZNO.get(0).getMark()) && (Ob.getMarkBySubject(minZNO.get(1).getSubject()) >= minZNO.get(1).getMark()) && (Ob.getMarkBySubject(minZNO.get(2).getSubject()) >= minZNO.get(2).getMark());
    }

}

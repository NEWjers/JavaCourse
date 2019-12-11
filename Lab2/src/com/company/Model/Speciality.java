package com.company.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Speciality {
    private int id;
    private String name;
    private List<Exam> minZNO;

    public static class Builder{
        private Speciality newSpeciality;
        public Builder(){
            newSpeciality = new Speciality();
        }

        public Builder withId(int id){
            newSpeciality.id = id;
            return this;
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

    public int getId(){
        return id;
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

    public void setId(int id1){
        this.id = id1;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speciality that = (Speciality) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(minZNO, that.minZNO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, minZNO);
    }

    public boolean checkEnrollee(Enrollee Ob){
        return (Ob.getMarkBySubject(minZNO.get(0).getSubject()) >= minZNO.get(0).getMark()) && (Ob.getMarkBySubject(minZNO.get(1).getSubject()) >= minZNO.get(1).getMark()) && (Ob.getMarkBySubject(minZNO.get(2).getSubject()) >= minZNO.get(2).getMark());
    }

}

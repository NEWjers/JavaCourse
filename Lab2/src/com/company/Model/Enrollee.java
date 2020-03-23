package com.company.Model;

import java.util.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;


public class Enrollee implements Comparable<Enrollee> {

    @NotNull
    private String id;

    @NotNull
    @Size(min = 1 , max = 20 , message = "Name can't be longer than 30 characters or shorter than 1")
    private String name;

    @NotNull
    @Size(min = 1 , max = 50 , message = "Surname can't be longer than 50 characters")
    private String surname;

    @NotNull
    @Size(min = 7 , message = "Date can't be shorter than 7 characters")
    private String birthday;

    private List<Exam> zno; // List<>

    @Override
    public int compareTo(Enrollee o) {
        return (int)this.averageZNO() - (int)o.averageZNO();
    }

    public static class Builder {
        private Enrollee newEnrollee;

        public Builder() {
            newEnrollee = new Enrollee();
        }

        public Builder withId(String ID) {
            newEnrollee.id = ID;
            return this;
        }

        public Builder withName(String name) {
            newEnrollee.name = name;
            return this;
        }

        public Builder withSurname(String surname) {
            newEnrollee.surname = surname;
            return this;
        }

        public Builder withBirthDay(String birthDay) {
            newEnrollee.birthday = birthDay;
            return this;
        }

        public Builder withZNO(Exam zno1, Exam zno2, Exam zno3) {
            newEnrollee.zno = new ArrayList<Exam>();
            newEnrollee.zno.add(zno1);
            newEnrollee.zno.add(zno2);
            newEnrollee.zno.add(zno3);
            return this;
        }

        public Enrollee build() throws IllegalStateException {
            try {
                Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
                Set<ConstraintViolation<Enrollee>> constraintViolations = validator.validate(newEnrollee);

                if (constraintViolations.isEmpty())
                    return newEnrollee;
                else {
                    Set<String> exceptions = new HashSet<>();
                    for (ConstraintViolation constraintViolation : constraintViolations) {
                        String fieldName = constraintViolation.getPropertyPath().toString().toUpperCase();
                        exceptions.add(fieldName + " " + constraintViolation.getMessage());
                    }
                    exceptions.forEach(System.out::println);
                    throw new IllegalStateException(exceptions.toString() + " ");
                }
            } catch (IllegalStateException e) {
                throw new IllegalStateException(e.getMessage());

            }
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

    public Exam getZNO1(){
        return zno.get(0);
    }

    public Exam getZNO2(){
        return zno.get(1);
    }

    public Exam getZNO3(){
        return zno.get(2);
    }

    public List<Exam> getZno() {
        return zno;
    }

    public String getId(){
        return  id;
    }

    public void setId(String id1){
        this.id = id1;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setBirthday(String birthday){
        this.birthday = birthday;
    }

    public void setMarkBySubject(String subject, int mark){
        for(Exam it:zno){
            if(it.getSubject()==subject)
                it.setMark(mark);
        }
    }

    public void setZNO(String subject, int mark,int index){
        int i = 1;
        for(Exam it:zno){
            if(i==index) {
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

    public float averageZNO(){
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





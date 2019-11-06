package com.company;

public class Main {

    public static void main(String[] args) {
	    Enrollee Student1 = new Enrollee.Builder()
                .withName("Serhiy")
                .withSurname("Pityk")
                .withBirthDay(2000,3,27)
                .withZNO(new Exam(188,"Math"),new Exam(164,"English"),new Exam(174,"Ukrainian"))
                .build();
	    System.out.println(Student1.averageZNO());
	    Speciality Speciality1 = new Speciality.Builder()
                .withName("Applied Math")
                .withZNO(new Exam(124,"Ukrainian"),new Exam(150,"Math"),new Exam(135,"English"))
                .build();
	    System.out.println(Speciality1.checkEnrollee(Student1));
    }
}

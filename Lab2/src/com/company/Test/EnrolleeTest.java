package com.company.Test;

import com.company.Model.Enrollee;
import com.company.Model.Exam;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnrolleeTest {

    @Test public void testAverageZNO(){
        Enrollee enrollee = new Enrollee.Builder()
                .withName("Serhiy")
                .withSurname("Pityk")
                .withBirthDay("27.03.2000")
                .withZNO(new Exam(188,"Math"),new Exam(164,"English"),new Exam(174,"Ukrainian"))
                .build();
        float actual = enrollee.averageZNO();
        float expected = 175;
        assertEquals(expected,actual);
    }

    @Test public void testGetMarkBySubject(){
        Enrollee enrollee = new Enrollee.Builder()
                .withName("Serhiy")
                .withSurname("Pityk")
                .withBirthDay("27.03.2000")
                .withZNO(new Exam(188,"Math"),new Exam(164,"English"),new Exam(174,"Ukrainian"))
                .build();
        int actual = enrollee.getMarkBySubject("Math");
        int expected = 188;
        assertEquals(expected,actual);
    }

    @Test public void testSetMarkBySubject(){
        Enrollee enrollee = new Enrollee.Builder()
                .withName("Serhiy")
                .withSurname("Pityk")
                .withBirthDay("27.03.2000")
                .withZNO(new Exam(188,"Math"),new Exam(164,"English"),new Exam(174,"Ukrainian"))
                .build();
        enrollee.setMarkBySubject("Math",190);
        int actual = enrollee.getZNO1().getMark();
        int expected = 190;
        assertEquals(expected,actual);
    }
}

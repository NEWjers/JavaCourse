package com.company.Test;

import com.company.Model.Enrollee;
import com.company.Model.Exam;
import com.company.NameComparator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameComparatorTest {

    @Test public void testCompare(){
        Enrollee enrollee = new Enrollee.Builder()
                .withName("Serhiy")
                .withSurname("Pityk")
                .withBirthDay("27.03.2000")
                .withZNO(new Exam(188,"Math"),new Exam(164,"English"),new Exam(174,"Ukrainian"))
                .build();
        Enrollee enrollee1 = new Enrollee.Builder()
                .withName("Artem")
                .withSurname("Shtefanesa")
                .withBirthDay("10.02.1999")
                .withZNO(new Exam(191,"Math"),new Exam(180,"English"),new Exam(182,"Ukrainian"))
                .build();
        NameComparator comparator = new NameComparator();
        boolean actual = comparator.compare(enrollee,enrollee1) > 0;
        boolean expected = true;
        assertEquals(expected,actual);
    }
}

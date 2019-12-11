package com.company;

import com.company.DataBase.DataBaseStructure;
import com.company.Model.Enrollee;
import com.company.Model.Exam;
import com.company.Model.Speciality;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        Enrollee Student1 = new Enrollee.Builder()
                .withId(1)
                .withSpeciality_Id(1)
                .withName("Serhiy")
                .withSurname("Pityk")
                .withBirthDay("27.03.2000")
                .withZNO(new Exam(88,"Math"),new Exam(164,"English"),new Exam(174,"Ukrainian"))
                .build();
        Speciality Speciality1 = new Speciality.Builder()
                .withId(1)
                .withName("Applied Math")
                .withZNO(new Exam(124,"Ukrainian"),new Exam(150,"Math"),new Exam(135,"English"))
                .build();

        Enrollee Student2 = new Enrollee.Builder()
                .withId(2)
                .withSpeciality_Id(1)
                .withName("Artem")
                .withSurname("Shtefanesa")
                .withBirthDay("10.02.1999")
                .withZNO(new Exam(191,"Math"),new Exam(180,"English"),new Exam(182,"Ukrainian"))
                .build();
        Enrollee Student3 = new Enrollee.Builder()
                .withId(3)
                .withSpeciality_Id(1)
                .withName("Margarita")
                .withSurname("Boiko")
                .withBirthDay("23.03.2000")
                .withZNO(new Exam(195,"Ukrainian"),new Exam(177,"Math"),new Exam(169,"English"))
                .build();
        DataBaseStructure.createEnrolleeTable();
        /*List<Enrollee> group = new ArrayList<>();
        group.add(Student1);
        group.add(Student2);
        group.add(Student3);
        Collections.sort(group,new NameComparator());
        StreamMethods op = new StreamMethods();
        List<Enrollee> group2 = op.filterSmallerThan(group,180);
        for (Enrollee o:group2) {
            System.out.println(o.averageZNO());
        }
        System.out.println(Student1.averageZNO());*/
    }
}

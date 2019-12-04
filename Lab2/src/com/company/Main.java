package com.company;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    //private static NameComparator comparator;

    public static void main(String[] args) throws IOException, TransformerException, ParserConfigurationException, SAXException {
        Enrollee Student1 = new Enrollee.Builder()
                .withName("Serhiy")
                .withSurname("Pityk")
                .withBirthDay("27.03.2000")
                .withZNO(new Exam(188,"Math"),new Exam(164,"English"),new Exam(174,"Ukrainian"))
                .build();
        //System.out.println(Student1.averageZNO());
        Speciality Speciality1 = new Speciality.Builder()
                .withName("Applied Math")
                .withZNO(new Exam(124,"Ukrainian"),new Exam(150,"Math"),new Exam(135,"English"))
                .build();
        //ReadWriteJson io = new ReadWriteJson();
        //String json = io.convertToJson(Student1);
        //io.writeToFile("C:\\Users\\Asus\\Desktop\\Java\\JavaCourse\\Lab2\\src\\com\\company\\File.json",json);
        //json = io.readFromFile("C:\\Users\\Asus\\Desktop\\Java\\JavaCourse\\Lab2\\src\\com\\company\\File.json");
        //ReadWriteXml io = new ReadWriteXml();
        //io.write("C:\\Users\\Asus\\Desktop\\Java\\JavaCourse\\Lab2\\src\\com\\company\\File.xml",Student1);
        //Enrollee Student2 = io.readFromFile("C:\\Users\\Asus\\Desktop\\Java\\JavaCourse\\Lab2\\src\\com\\company\\File.xml");
        Enrollee Student2 = new Enrollee.Builder()
                .withName("Artem")
                .withSurname("Shtefanesa")
                .withBirthDay("10.02.1999")
                .withZNO(new Exam(191,"Math"),new Exam(180,"English"),new Exam(182,"Ukrainian"))
                .build();
        Enrollee Student3 = new Enrollee.Builder()
                .withName("Margarita")
                .withSurname("Boiko")
                .withBirthDay("23.03.2000")
                .withZNO(new Exam(195,"Ukrainian"),new Exam(177,"Math"),new Exam(169,"English"))
                .build();
        List<Enrollee> group = new ArrayList<>();
        group.add(Student1);
        group.add(Student2);
        group.add(Student3);
        Collections.sort(group,new NameComparator());
        /*for (Enrollee stud:group) {
            System.out.println(stud.averageZNO());
        }*/
        StreamMethods op = new StreamMethods();
        List<Enrollee> group2 = op.filterSmallerThan(group,180);
        for (Enrollee o:group2) {
            System.out.println(o.averageZNO());
        }
    }
}

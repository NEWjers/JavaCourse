package com.company;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {

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
        ReadWriteXml io = new ReadWriteXml();
        //io.write("C:\\Users\\Asus\\Desktop\\Java\\JavaCourse\\Lab2\\src\\com\\company\\File.xml",Student1);
        Enrollee Student2 = io.readFromFile("C:\\Users\\Asus\\Desktop\\Java\\JavaCourse\\Lab2\\src\\com\\company\\File.xml");
        System.out.println(Student2.getZNO3().getSubject());
        System.out.println(Student2.getZNO3().getMark());
    }
}

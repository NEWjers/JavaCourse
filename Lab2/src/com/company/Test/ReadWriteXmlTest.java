package com.company.Test;

import com.company.Model.Enrollee;
import com.company.Model.Exam;
import com.company.ReadWrite.ReadWriteXml;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadWriteXmlTest {

    @Test public void readFromFileTest() throws ParserConfigurationException, SAXException, IOException {
        ReadWriteXml io = new ReadWriteXml();
        Enrollee actual = io.readFromFile("C:\\Users\\Asus\\Desktop\\Java\\JavaCourse\\Lab2\\src\\com\\company\\File.xml");
        Enrollee expected = new Enrollee.Builder()
                .withName("Serhiy")
                .withSurname("Pityk")
                .withBirthDay("27.03.2000")
                .withZNO(new Exam(188,"Math"),new Exam(164,"English"),new Exam(174,"Ukrainian"))
                .build();
        assertEquals(expected.getName(),actual.getName());
    }

    @Test public void writeToFileTest() throws ParserConfigurationException, TransformerException, IOException {
        ReadWriteXml io = new ReadWriteXml();
        Enrollee stud1 = new Enrollee.Builder()
                .withName("Serhiy")
                .withSurname("Pityk")
                .withBirthDay("27.03.2000")
                .withZNO(new Exam(188,"Math"),new Exam(164,"English"),new Exam(174,"Ukrainian"))
                .build();
        io.writeToFile("C:\\Users\\Asus\\Desktop\\Java\\JavaCourse\\Lab2\\src\\com\\company\\File.xml",stud1);
    }

}

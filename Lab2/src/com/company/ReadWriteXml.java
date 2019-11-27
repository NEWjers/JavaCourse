package com.company;

import java.io.File;
import java.io.IOException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;

public class ReadWriteXml {

    public void writeToFile(String File, Enrollee enrollee1) throws IOException, ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element enrollee = document.createElement("Enrollee");
        Element name = document.createElement("Name");
        Text names = document.createTextNode(enrollee1.getName());
        Element surname = document.createElement("Surname");
        Text surnames = document.createTextNode(enrollee1.getSurname());
        Element birthday = document.createElement("Birthday");
        Text birthdays = document.createTextNode(enrollee1.getBirthday());
        Element zno1 = document.createElement("ZNO1");
        Element mark1 = document.createElement("Mark");
        Text marks1 = document.createTextNode(Integer.toString(enrollee1.getZNO1().getMark()));
        Element subject1 = document.createElement("Subject");
        Text subjects1 = document.createTextNode(enrollee1.getZNO1().getSubject());
        Element zno2 = document.createElement("ZNO2");
        Element mark2 = document.createElement("Mark");
        Text marks2 = document.createTextNode(Integer.toString(enrollee1.getZNO2().getMark()));
        Element subject2 = document.createElement("Subject");
        Text subjects2 = document.createTextNode(enrollee1.getZNO2().getSubject());
        Element zno3 = document.createElement("ZNO3");
        Element mark3 = document.createElement("Mark");
        Text marks3 = document.createTextNode(Integer.toString(enrollee1.getZNO3().getMark()));
        Element subject3 = document.createElement("Subject");
        Text subjects3 = document.createTextNode(enrollee1.getZNO3().getSubject());
        document.appendChild(enrollee);
        enrollee.appendChild(name);
        name.appendChild(names);
        enrollee.appendChild(surname);
        surname.appendChild(surnames);
        enrollee.appendChild(birthday);
        birthday.appendChild(birthdays);
        enrollee.appendChild(zno1);
        zno1.appendChild(mark1);
        mark1.appendChild(marks1);
        zno1.appendChild(subject1);
        subject1.appendChild(subjects1);
        enrollee.appendChild(zno2);
        zno2.appendChild(mark2);
        mark2.appendChild(marks2);
        zno2.appendChild(subject2);
        subject2.appendChild(subjects2);
        enrollee.appendChild(zno3);
        zno3.appendChild(mark3);
        mark3.appendChild(marks3);
        zno3.appendChild(subject3);
        subject3.appendChild(subjects3);

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        transformer.transform(new DOMSource(document),new StreamResult(new FileOutputStream(File)));
    }

    public Enrollee readFromFile(String file) throws IOException, ParserConfigurationException, SAXException {
        Enrollee enrollee = new Enrollee.Builder()
                .withName("")
                .withSurname("")
                .withBirthDay("")
                .withZNO(new Exam(),new Exam(),new Exam())
                .build();
        String buffer[];
        int flag = 1;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(file));

        Element element = document.getDocumentElement();
        NodeList nodeList = element.getChildNodes();
        for(int i = 0; i < nodeList.getLength() ; i++){
            if(nodeList.item(i) instanceof Element){
                if(((Element) nodeList.item(i)).getTagName() == "Name")
                    enrollee.setName(nodeList.item(i).getTextContent());
                if(((Element) nodeList.item(i)).getTagName() == "Surname")
                    enrollee.setSurname(nodeList.item(i).getTextContent());
                if(((Element) nodeList.item(i)).getTagName() == "Birthday")
                    enrollee.setBirthday(nodeList.item(i).getTextContent());
                if(((Element) nodeList.item(i)).getTagName() == "ZNO1"){
                    NodeList marks1 = ((Element) nodeList.item(i)).getElementsByTagName("Mark");
                    NodeList subjects1 = ((Element) nodeList.item(i)).getElementsByTagName("Subject");
                    enrollee.setZNO(subjects1.item(0).getTextContent(),Integer.parseInt(marks1.item(0).getTextContent()),1);
                }
                if(((Element) nodeList.item(i)).getTagName() == "ZNO2"){
                    NodeList marks2 = ((Element) nodeList.item(i)).getElementsByTagName("Mark");
                    NodeList subjects2 = ((Element) nodeList.item(i)).getElementsByTagName("Subject");
                    enrollee.setZNO(subjects2.item(0).getTextContent(),Integer.parseInt(marks2.item(0).getTextContent()),2);
                }
                if(((Element) nodeList.item(i)).getTagName() == "ZNO3"){
                    NodeList marks3 = ((Element) nodeList.item(i)).getElementsByTagName("Mark");
                    NodeList subjects3 = ((Element) nodeList.item(i)).getElementsByTagName("Subject");
                    enrollee.setZNO(subjects3.item(0).getTextContent(),Integer.parseInt(marks3.item(0).getTextContent()),3);
                }
            }
        }
        return enrollee;
    }

}

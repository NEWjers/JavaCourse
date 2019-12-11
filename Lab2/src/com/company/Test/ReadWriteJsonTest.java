package com.company.Test;

import com.company.Model.Enrollee;
import com.company.Model.Exam;
import com.company.ReadWrite.ReadWriteJson;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadWriteJsonTest {

    @Test public void convertToJsonTest(){
        Enrollee enrollee = new Enrollee.Builder()
                .withName("Serhiy")
                .withSurname("Pityk")
                .withBirthDay("27.03.2000")
                .withZNO(new Exam(188,"Math"),new Exam(164,"English"),new Exam(174,"Ukrainian"))
                .build();
        ReadWriteJson io = new ReadWriteJson();
        String actual = io.convertToJson(enrollee);
        String expected = "{\n" +
                "  \"name\": \"Serhiy\",\n" +
                "  \"surname\": \"Pityk\",\n" +
                "  \"birthday\": \"27.03.2000\",\n" +
                "  \"zno\": [\n" +
                "    {\n" +
                "      \"mark\": 188,\n" +
                "      \"subject\": \"Math\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"mark\": 164,\n" +
                "      \"subject\": \"English\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"mark\": 174,\n" +
                "      \"subject\": \"Ukrainian\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        assertEquals(expected,actual);
    }

    @Test public void convertToEnrolleeTest(){
        String json = "{\n" +
                "  \"name\": \"Serhiy\",\n" +
                "  \"surname\": \"Pityk\",\n" +
                "  \"birthday\": \"27.03.2000\",\n" +
                "  \"zno\": [\n" +
                "    {\n" +
                "      \"mark\": 188,\n" +
                "      \"subject\": \"Math\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"mark\": 164,\n" +
                "      \"subject\": \"English\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"mark\": 174,\n" +
                "      \"subject\": \"Ukrainian\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        Enrollee expectedEnrollee = new Enrollee.Builder()
                .withName("Serhiy")
                .withSurname("Pityk")
                .withBirthDay("27.03.2000")
                .withZNO(new Exam(188,"Math"),new Exam(164,"English"),new Exam(174,"Ukrainian"))
                .build();
        ReadWriteJson io = new ReadWriteJson();
        Enrollee actualEnrollee = io.convertToEnrolle(json);
        int actual = expectedEnrollee.compareTo(actualEnrollee);
        int expected = 0;
        assertEquals(expected,actual);
    }

}

package com.company;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionalTest {
    @Test
    public void testInt_pos(){
        Functional obj = new Functional();
        int actual = obj.intTaskMinutes(12000);
        int expected = 200;
        assertEquals(expected, actual);
    }
    @Test
    public void testInt_neg(){
        Functional obj = new Functional();
        int actual = obj.intTaskMinutes(1000);
        int expected = 200;
        assertEquals(expected, actual);
    }
    @Test
    public void testIf_pos(){
        Functional obj = new Functional();
        int actual = obj.ifTaskIndex(1,4,1,1);
        int expected = 2;
        assertEquals(expected, actual);
    }
    @Test
    public void testIf_neg(){
        Functional obj = new Functional();
        int actual = obj.ifTaskIndex(1,1,1,4);
        int expected = 3;
        assertEquals(expected, actual);
    }
    @Test
    public void testBool_pos(){
        Functional obj = new Functional();
        boolean actual = obj.boolTaskNumbers(1,-1,6);
        boolean expected = true;
        assertEquals(expected, actual);
    }
    @Test
    public void testBool_neg(){
        Functional obj = new Functional();
        boolean actual = obj.boolTaskNumbers(1,5,6);
        boolean expected = true;
        assertEquals(expected, actual);
    }
    @Test
    public void testFor_pos(){
        Functional obj = new Functional();
        long actual = obj.forTaskFactorial(3);
        long expected = 6;
        assertEquals(expected, actual);
    }
    @Test
    public void testFor_neg(){
        Functional obj = new Functional();
        long actual = obj.forTaskFactorial(4);
        long expected = 26;
        assertEquals(expected, actual);
    }
    @Test
    public void testWhile_pos(){
        Functional obj = new Functional();
        int actual = obj.whileTaskRevers(1256);
        int expected = 6521;
        assertEquals(expected, actual);
    }
    @Test
    public void testWhile_neg(){
        Functional obj = new Functional();
        int actual = obj.whileTaskRevers(56);
        int expected = 56;
        assertEquals(expected, actual);
    }
    @Test
    public void testArray_neg(){
        Functional obj = new Functional();
        int arr[] = new int[5];
        for(int i = 0;i<5;i++){
            arr[i] = i;
        }
        int actual = obj.arrayTaskLastIndex(arr,5);
        int expected = 2;
        assertEquals(expected, actual);
    }
    @Test
    public void testMatrix_neg(){
        Functional obj = new Functional();
        int matrix[][] = new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                matrix[i][j] = 1;
            }
        }
        int[] actual = obj.matrixTaskSum(matrix,3,3);
        int expected = 3;
        assertEquals(expected, actual);
    }
    @Test
    public void testSwitch_pos(){
        Functional obj = new Functional();
        String actual = obj.switchTaskYear(2000);
        String expected = "white dragon";
        assertEquals(expected, actual);
    }
}
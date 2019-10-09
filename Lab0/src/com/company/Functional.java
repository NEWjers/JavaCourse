package com.company;

import java.time.Year;
import java.util.Scanner;
import java.math.MathContext;

enum Color{
    white,
    black,
    green,
    red,
    yellow
}

enum Animal{
    rat,
    cow,
    tiger,
    hear,
    dragon,
    snake,
    horse,
    ship,
    monkey,
    han,
    dog,
    pig
}

public class Functional {
    public int intTaskMinutes(int n){

        return n/60;

    }
    public int ifTaskIndex(int a1,int a2,int a3,int a4){
        int res = -1;
        if((a1 == a2)&&(a1==a3)&&(a1!=a4)){
            res = 4;
        }
        else if((a1==a2)&&(a1==a4)&&(a1!=a3)){
            res = 3;
        }
        else if ((a1==a3)&&(a1==a4)&&(a1!=a2)){
            res = 2;
        }
        else if((a2==a3)&&(a2==a4)&&(a2!=a1)){
            res = 1;
        }
        return res;
    }
    public boolean boolTaskNumbers(int a,int b,int c){
        return(a==-b)||(a==-c)||(b==-c);
    }
    public long forTaskFactorial(int N){
        long res = 1;
        for(int i = 1;i <= N;i++){
            res *= i;
        }
        return res;
    }
    public int whileTaskRevers(int Num){
        int res = 0;
        while(Num>0){
            res = res * 10 + Num % 10;
            Num = Num / 10;
        }
        return res;
    }
    public int arrayTaskLastIndex(int arr[],int size){
        int res = -1;
        for(int i = 0;i < size;i++){
            if((arr[i]>arr[0])&&(arr[i]<arr[size-1])){
                res = i;
            }
        }
        return res;
    }
    public int[] matrixTaskSum(int arr[][],int m,int n){
        int res[] = new int[n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                res[i] += arr[i][j];
            }
        }
        return res;
    }
    public Dot inputOutputTaskSquare(int x1,int y1,int x2,int y2){
        int x,y;
        Dot res = new Dot();
        y = Math.abs(y1 - y2);
        x = Math.abs(x1 - x2);
        res.x = (x + y) * 2;
        res.y = x * y;
        return res;
    }
    public String switchTaskYear(int Year){
        String res1 = "";
        String res2 = "";
        switch (Year % 10){
            case 1 : res1 = Color.white + " ";
                break;
            case 0 : res1 = Color.white.toString() + " ";
                break;
            case 2 : res1 = Color.black.toString() + " ";
                break;
            case 3 : res1 = Color.black.toString() + " ";
                break;
            case 4 : res1 = Color.green.toString() + " ";
                break;
            case 5 : res1 = Color.green.toString() + " ";
                break;
            case 6 : res1 = Color.red.toString() + " ";
                break;
            case 7 : res1 = Color.red.toString() + " ";
                break;
            case 8 : res1 = Color.yellow.toString() + " ";
                break;
            case 9 : res1 = Color.yellow.toString() + " ";
                break;
        }
        switch((Year + 8) % 12){
            case 0 : res2 = Animal.rat.toString();
                break;
            case 1 : res2 = Animal.cow.toString();
                break;
            case 2 : res2 = Animal.tiger.toString();
                break;
            case 3 : res2 = Animal.hear.toString();
                break;
            case 4 : res2 = Animal.dragon.toString();
                break;
            case 5 : res2 = Animal.snake.toString();
                break;
            case 6 : res2 = Animal.horse.toString();
                break;
            case 7 : res2 = Animal.ship.toString();
                break;
            case 8 : res2 = Animal.monkey.toString();
                break;
            case 9 : res2 = Animal.han.toString();
                break;
            case 10 : res2 = Animal.dog.toString();
                break;
            case 11 : res2 = Animal.pig.toString();
                break;
        }
        String res = res1 + res2;
        return res;
    }
}

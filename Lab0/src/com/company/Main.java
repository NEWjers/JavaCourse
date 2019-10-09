package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Functional Ob = new Functional();
        Scanner out = new Scanner(System.in);
        String result;
        result = Ob.switchTaskYear(2000);
        System.out.print(result);
    }
}

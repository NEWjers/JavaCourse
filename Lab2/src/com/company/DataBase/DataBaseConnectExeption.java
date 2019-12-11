package com.company.DataBase;

public class DataBaseConnectExeption extends RuntimeException {
    public DataBaseConnectExeption(String message){
        super(message);
    }
}

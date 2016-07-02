package com.epam.trainings.java.fundamentals.jdbc.cp;

public class ConnectionPoolException extends Exception {
    public ConnectionPoolException(String message, Exception e){
        super(message, e);
    }
}
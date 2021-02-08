package com.example.exam.exceptions;

public class PreferedTimeException extends RuntimeException {
    public PreferedTimeException() {
        super("You can`t modify the prefered time and set the delivered field to true");
    }
}

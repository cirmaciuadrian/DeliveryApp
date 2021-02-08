package com.example.exam.exceptions;


    public class ErrorUpdateException extends RuntimeException {
        public ErrorUpdateException() {
            super("Error while updating the deliver");
        }
    }


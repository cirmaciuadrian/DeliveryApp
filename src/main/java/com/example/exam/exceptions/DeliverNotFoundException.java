package com.example.exam.exceptions;

public class DeliverNotFoundException extends RuntimeException {
    public DeliverNotFoundException(long driverId) {
        super("The deliver with id " + driverId + " doesn't exist.");
    }
}

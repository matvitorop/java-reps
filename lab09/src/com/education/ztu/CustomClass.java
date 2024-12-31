package com.education.ztu;

import java.lang.reflect.*;

public class CustomClass {
    public String publicField;

    private int privateField;

    public CustomClass() {
        this.publicField = "Default";
        this.privateField = 42;
    }

    public CustomClass(String publicField, int privateField) {
        this.publicField = publicField;
        this.privateField = privateField;
    }

    public void publicMethod() {
        System.out.println("Public method called!");
    }

    public void publicMethodWithArgs(String message, int number) {
        System.out.println("Message: " + message + ", Number: " + number);
    }

    private String privateMethod() {
        return "Private method called!";
    }
}
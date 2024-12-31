package com.education.ztu;

public class AnnotatedClass {
    @CustomAnnotation(value = "Custom Value", priority = 10)
    public void annotatedMethod() {
        System.out.println("This is an annotated method.");
    }

    @CustomAnnotation
    public void defaultAnnotatedMethod() {
        System.out.println("This method uses default annotation values.");
    }
}
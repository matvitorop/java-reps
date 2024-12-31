package com.education.ztu;

import java.lang.reflect.Method;

public class Task3 {
    public static void main(String[] args) {
        try {
            Class<?> class1 = AnnotatedClass.class;

            Method[] methods = class1.getDeclaredMethods();

            for (Method method : methods) {
                if(method.isAnnotationPresent(CustomAnnotation.class)) {
                    CustomAnnotation annotation = method.getAnnotation(CustomAnnotation.class);

                    System.out.println("Method: " + method.getName());
                    System.out.println(" - Value: " + annotation.value());
                    System.out.println(" - Priority: " + annotation.priority());
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

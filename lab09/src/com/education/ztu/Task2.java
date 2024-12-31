package com.education.ztu;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Task2 {
    public static void main(String[] args) {
        try{
            // TASK 2
            Class<CustomClass> class1 = CustomClass.class;

            Class class2 = null;

            try {
                class2 = Class.forName("com.education.ztu.CustomClass");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            CustomClass obj = new CustomClass();
            Class<?> class3 = obj.getClass();

            System.out.println("Class obtained by 3 methods:");
            System.out.println(class1);
            System.out.println(class2);
            System.out.println(class3);
            System.out.println();

            // TASK 3
            System.out.println("Declared Fields:");
            Field[] fields = class1.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("- Name: " + field.getName() + ", Type: " + field.getType());
            }

            System.out.println("\nDeclared Methods:");
            Method[] methods = class1.getDeclaredMethods();
            for (Method method : methods) {
                System.out.print("- Name: " + method.getName() + ", Return Type: " + method.getReturnType() + ", Parameter Types: ");
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (Class<?> paramType : parameterTypes) {
                    System.out.print(paramType.getName() + " ");
                }
                System.out.println();
            }

            System.out.println("\nDeclared Constructors:");
            Constructor<?>[] constructors = class1.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.print("- Name: " + constructor.getName() + ", Parameter Types: ");
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                for (Class<?> paramType : parameterTypes) {
                    System.out.print(paramType.getName() + " ");
                }
                System.out.println();
            }

            // TASK 4 - 5
            Constructor<?> defaultConstructor = class1.getConstructor();
            Object newInstance = defaultConstructor.newInstance();
            System.out.println("\nInstance of CustomClass created!");


            Method publicMethod = class1.getMethod("publicMethod");
            publicMethod.invoke(newInstance);

            Method publicMethodWithArgs = class1.getMethod("publicMethodWithArgs", String.class, int.class);
            publicMethodWithArgs.invoke(newInstance, "Hello, Reflection!", 123);

            // TASK 6
            Field privateField = class1.getDeclaredField("privateField");
            privateField.setAccessible(true);
            privateField.set(newInstance, 99);
            int privateValue = (int) privateField.get(newInstance);
            System.out.println("\nPrivate field value set to: " + privateValue);


            Method privateMethod = class1.getDeclaredMethod("privateMethod");
            privateMethod.setAccessible(true);
            String result = (String) privateMethod.invoke(newInstance);
            System.out.println("Result of private method: " + result);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

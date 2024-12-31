package com.education.ztu;

public interface Human {
    void sayAge();

    void sayGender();

    void sayLocation();

    void sayName();

    default void whoIAm(){
        System.out.println("I am Human");
    }
}

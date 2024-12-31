package com.education.ztu;

public abstract class Person implements Human {
    protected int age;
    protected String firstname;
    protected String lastname;
    protected Location location;
    protected Gender gender;
    protected String fullInfo;
    protected static int counter = 0;

    public Person()
    {
        this.firstname = "Default Firstname";
        this.lastname = "Default Lastname";
        this.age = 18;
        this.gender = Gender.MALE;
        this.fullInfo = "Default Full Info";
        this.location = Location.KIEV;
        this.counter++;
    }

    public Person(String firstname, String lastname, String fullInfo, Gender gender, Location location, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.fullInfo = fullInfo;
        this.gender = gender;
        this.location = location;
        this.age = age;
        this.counter++;
    }
    public abstract String getOccupation();


    @Override
    public void sayAge() {
        System.out.println("Age: " + this.age);
    }

    @Override
    public void sayGender() {
        System.out.println("Gender: " + this.gender);
    }

    @Override
    public void sayLocation() {
        System.out.println("Location: " + this.location);
    }

    @Override
    public void sayName() {
        System.out.println(this.firstname + " " + this.lastname);
    }

    public static void showCounter() {
        System.out.println("Total Persons: " + counter);
    }
}

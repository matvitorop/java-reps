package com.education.ztu;

public class Teacher extends Person {
    private String subject;
    private String university;
    private Car car;

    public Teacher() {
        super();
        this.subject = "DefaultSubject";
        this.university = "DefaultUniversity";
        this.car = new Car("DefaultBrand");
    }

    public Teacher(String firstname, String lastname, String fullinfo, int age, Gender gender, Location location, String subject, String university, Car car) {
        super(firstname, lastname, fullinfo, gender, location, age);
        this.subject = subject;
        this.university = university;
        this.car = car;
    }

    @Override
    public String getOccupation() {
        return "Teacher";
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
    public boolean getCarStatus() {
        return this.car.getCarStatus();
    }
    @Override
    public void whoIAm(){
        System.out.println("I am teacher");
    }

}

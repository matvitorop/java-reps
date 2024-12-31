package com.education.ztu;

public class Employee extends Person {
    private String company;
    private String position;
    private Car car;

    public Employee() {
        super();
        this.company = "DefaultCompany";
        this.position = "DefaultPosition";
        this.car = new Car("DefaultBrand");
    }

    public Employee(String firstname, String lastname, String fullInfo, int age, Gender gender, Location location, String company, String position, Car car) {
        super(firstname, lastname, fullInfo, gender, location, age);
        this.company = company;
        this.position = position;
        this.car = car;
    }


    @Override
    public String getOccupation() {
        return "Employee";
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public void whoIAm(){
        System.out.println("I am teacher");
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

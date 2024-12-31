package com.education.ztu;

public class Student extends Person {
    private String course;
    private String specialty;
    private String university;

    public Student() {
        super();
        this.course = "DefaultCourse";
        this.specialty = "DefaultSpecialty";
        this.university = "DefaultUniversity";
    }

    public Student(String firstname, String lastname, String fullInfo,int age, Gender gender, Location location, String course, String specialty, String university) {
        super(firstname, lastname, fullInfo, gender, location, age);
        this.course = course;
        this.specialty = specialty;
        this.university = university;
    }

    @Override
    public String getOccupation() {
        return "Student";
    }

    public String getCourse() {
        return this.course;
    }

    public void setCourse(String course) {
        this.course = course;
    }


    @Override
    public void whoIAm(){
        System.out.println("I am student");
    }
}

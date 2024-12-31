package com.education.ztu;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("John", "Doe", "The best student int the world",20, Gender.MALE, Location.KIEV, "Computer Science", "Software Engineering", "ZTU");
        Teacher teacher = new Teacher("Jane", "Smith", "The best teacher int the world",40, Gender.FEMALE, Location.ZHYTOMYR, "Mathematics", "ZTU", new Car("Toyota"));
        Employee employee = new Employee("Mark", "Johnson","The best employee in the world", 35, Gender.MALE, Location.VINNYTSYA, "TechCorp", "Developer", new Car("Honda"));

        student.sayName();
        teacher.sayName();
        employee.sayName();

        Car.Engine engine = teacher.getCar().new Engine();
        engine.startEngine();


        if (teacher instanceof Human) {
            System.out.println("Teacher is a human.");
        }

        if (engine.isEngineWorks()) {
            System.out.println("Engine is working now");
        }

        Person.showCounter();

        // Виклик методу average з класу Operation
        //System.out.println("Average: " + Operation.average(5, 10, 15));
    }
}

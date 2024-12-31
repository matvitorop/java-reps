package com.education.ztu;
import com.education.ztu.game.Student;
import com.education.ztu.game.Team;
import com.education.ztu.game.Participant;


public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("Alice", 20);
        Student student2 = new Student("Bob", 22);

        Team<Student> studentTeam = new Team<>("Vpered");
        studentTeam.addNewParticipant(student1);
        studentTeam.addNewParticipant(student2);

        Team<Student> clonedTeam = new Team<>(studentTeam);

        System.out.println("Original Team: " + studentTeam);
        System.out.println("Cloned Team: " + clonedTeam);

        System.out.println("Teams are equal: " + studentTeam.equals(clonedTeam));
        System.out.println("Original Team hashCode: " + studentTeam.hashCode());
        System.out.println("Cloned Team hashCode: " + clonedTeam.hashCode());

        System.out.println(studentTeam.getParticipant(0).equals(clonedTeam.getParticipant(0)));

        Team<Student> studentTeam2 = new Team<>("Shvydko");
        studentTeam2.addNewParticipant(new Student("Charlie", 21));
        studentTeam.playWith(studentTeam2);
    }
}

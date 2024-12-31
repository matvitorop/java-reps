package com.education.ztu;
import com.education.ztu.game.Participant;
import com.education.ztu.game.NameAgeComparator;
import com.education.ztu.game.ParticipantComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Main2 {
    public static void main(String[] args) {
        List<Participant> participants = new ArrayList<>();
        participants.add(new Participant("Alice", 25) {});
        participants.add(new Participant("Bob", 22) {});
        participants.add(new Participant("Charlie", 25) {});
        participants.add(new Participant("Alice", 30) {});


        Collections.sort(participants);
        System.out.println("Sorted by name:");
        for (Participant p : participants) {
            System.out.println(p);
        }


        participants.sort(new ParticipantComparator());
        System.out.println("\nSorted by age:");
        for (Participant p : participants) {
            System.out.println(p);
        }


        participants.sort(NameAgeComparator.getComparator());
        System.out.println("\nSorted by name and age:");
        for (Participant p : participants) {
            System.out.println(p);
        }
    }
}

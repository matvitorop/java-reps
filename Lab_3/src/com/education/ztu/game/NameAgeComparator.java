package com.education.ztu.game;
import java.util.Comparator;

public class NameAgeComparator {
    public static Comparator<Participant> getComparator() {
        return Comparator.comparing(Participant::getName)
                .thenComparing(Participant::getAge);
    }
}